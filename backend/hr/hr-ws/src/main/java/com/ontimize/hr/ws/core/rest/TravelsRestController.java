package com.ontimize.hr.ws.core.rest;


import com.ontimize.hr.api.core.service.IDeliveryNotesService;
import com.ontimize.hr.model.core.dao.TravelsDao;
import com.ontimize.hr.model.core.dao.DeliveryNotesDao;
import com.ontimize.hr.model.core.service.TravelsService;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.ITravelsService;
import com.ontimize.jee.server.rest.ORestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/travels")
public class TravelsRestController extends ORestController<ITravelsService> {

    @Autowired
    private ITravelsService travelService;
    @Autowired
    private IDeliveryNotesService deliveryNotesService;

    @Override
    public ITravelsService getService() {
        return this.travelService;
    }

    @RequestMapping( value="/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insertData(@RequestBody Map<String,Object> body) throws ParseException {
        ResponseEntity<String> re = null;
        Map<String, Object> data = manageData(body);

        Object id_delivery_note = getDeliveryNote(body.get("delivery_note"));

        if(id_delivery_note == null &&  esEntrada(data)) {
            //es una entrada
            travelService.travelInsert(data);
            re = new ResponseEntity<String>("Travel Insert OK",
                                            HttpStatus.CREATED);

        }else if(id_delivery_note == null && !esEntrada(data)) {
            //Un camión sale sin entrar
            re = new ResponseEntity<String>("El camión no pasó por el sensor de entrada",
                                            HttpStatus.BAD_REQUEST);

        }else if(id_delivery_note != null && esEntrada(data)) {
            //Ya existe este delivery note para otra entrada y es un error. 2 Id_delivery_note iguales.
            re = new ResponseEntity<String>("Ya existe ese delivery note para otra entrada!!!",
                                            HttpStatus.BAD_REQUEST);

        } else {
            //El delivery note existe y es una salida. Actualiza el registro en travels.
            re = actualizaTravel(id_delivery_note, data);
        }
        return re;
    }

    public Timestamp stringToTimestamp(String timestampString){
        Timestamp datetime = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            datetime = new Timestamp(dateFormat.parse(timestampString).getTime());
        }catch(Exception e){
            e.printStackTrace();
        }
        return datetime;
    }


    public Map<String, Object> manageData(Map<String, Object> body){
        Map <String, Object> data = new HashMap<>(body);
        Object calculated_volume = data.getOrDefault("calculated_volume", null);

        String timestampString = (String) data.remove("date"); // Aquí debes poner tu timestamp en formato de cadena
        Timestamp datetime = stringToTimestamp(timestampString);

        Object scan_volume = data.remove("scan_volume");
        Object id_dev = data.remove("dev");
        if(calculated_volume == null){
            data.put(TravelsDao.ATTR_ID_DEV_IN, id_dev);
            data.put("scan_volume_in",scan_volume);
            data.put("datetime_in",datetime);
        }
        else{
            data.put(TravelsDao.ATTR_ID_DEV_OUT, id_dev);
            data.put("scan_volume_out",scan_volume);
            data.put("datetime_out",datetime);
        }

        data.put(TravelsDao.ATTR_CALCULATED_VOLUME, calculated_volume);
        Object plate = data.remove("plate");
        data.put(TravelsDao.ATTR_ID_PLATE, plate);
        Object trailer = data.remove("trailer_plate");
        data.put(TravelsDao.ATTR_ID_TRAILER_PLATE, trailer);
        Object deliveryNote = data.remove("delivery_note");
        data.put(TravelsDao.ATTR_ID_DELIVERY_NOTE, deliveryNote);
        return data;
    }

    public ResponseEntity<String> actualizaTravel(Object idDeliveryNote, Map<String, Object> data){
        HashMap<String, Object> keyMap = new HashMap<>();
        List<String> attr = new ArrayList<>();
        keyMap.put(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE, idDeliveryNote);
        attr.add(TravelsDao.ATTR_ID_TRAVEL);
        EntityResult travelResult = travelService.travelQuery(keyMap, attr);

        if (!travelResult.isEmpty()) {
            Object idTravel = travelResult.getRecordValues(0).get(TravelsDao.ATTR_ID_TRAVEL);
            keyMap.clear();
            keyMap.put(TravelsDao.ATTR_ID_TRAVEL, idTravel);
            EntityResult et1 = travelService.travelUpdate(data, keyMap);
            return new ResponseEntity<String>("Travel actualizado correctamente", HttpStatus.OK);
        } else {
            return  new ResponseEntity<String>("¡No existe ningun travel con ese delivery note!",
                                              HttpStatus.BAD_REQUEST);
        }
    }

   public boolean esEntrada(Map<String, Object> data){
        return data.get("calculated_volume") == null;
    }
    public Object getDeliveryNote(Object deliveryNote){
        HashMap<String, Object> keyMap = new HashMap<>();
        List<String> attr = new ArrayList<>();
        keyMap.put(DeliveryNotesDao.ATTR_DELIVERY_NAME, deliveryNote);
        attr.add(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);

        EntityResult et = deliveryNotesService.deliverynotesQuery(keyMap, attr);
        return et.getRecordValues(0).get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
    }
}

/*
Caso 1
volumen entrada < 1 or
volumen salida <1



Caso 2
volumen entrada > 1 and
volumen salida > 1



Caso 3
delivery_note
    307999
    308266
    307950
    307979
    10000012811
 */

