package com.ontimize.hr.ws.core.rest;


import com.ontimize.hr.api.core.service.IDeliveryNotesService;
import com.ontimize.hr.model.core.dao.TravelsDao;
import com.ontimize.hr.model.core.dao.DeliveryNotesDao;
import com.ontimize.hr.model.core.service.DeliveryNotesService;
import com.ontimize.jee.common.dto.EntityResult;
import org.bouncycastle.util.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        ResponseEntity re = null;
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

        HashMap<String, Object> keyMap = new HashMap<>();
        List<String> attr = new ArrayList<>();
        keyMap.put(DeliveryNotesDao.ATTR_DELIVERY_NAME, deliveryNote);
        attr.add(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);

        EntityResult et = deliveryNotesService.deliverynotesQuery(keyMap, attr);
        if(et.isEmpty() && calculated_volume == null) {
            travelService.travelInsert(data);
            re = new ResponseEntity<String>("Travel Insert OK",  HttpStatus.CREATED);
        } else if(calculated_volume != null) {
            keyMap.clear();
            attr.clear();
            Object idDeliveryNote = et.getRecordValues(0).get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
            keyMap.put(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE, idDeliveryNote);
            attr.add(TravelsDao.ATTR_ID_TRAVEL);

            EntityResult travelResult = travelService.travelQuery(keyMap, attr);

            if (!travelResult.isEmpty()) {
                Object idTravel = travelResult.getRecordValues(0).get(TravelsDao.ATTR_ID_TRAVEL);
                keyMap.clear();
                keyMap.put(TravelsDao.ATTR_ID_TRAVEL, idTravel);
                EntityResult et1 = travelService.travelUpdate(data, keyMap);
            } else {
                re =  new ResponseEntity<String>("¡Hola mundo, soy una tetera!",  HttpStatus.I_AM_A_TEAPOT);
            }
        }else {
            re = new ResponseEntity<String>("Bug! Ya existe ese delivery note!!!", HttpStatus.BAD_REQUEST);
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
}

/*{
    "dev": "OUT_SCAN_1",
    "date": "2023-03-01 07:25:15.211",
    "scan_volume": 0.7155306144571006,
    "calculated_volume": 70.94168090820312,
    "plate": "BCY8356",
    "height": 2.4196081161499023,
    "width": 2.9600000381469727,
    "length": 13.75999927520752,
    "trailer_plate": "RDTB2218",
    "delivery_note": 10000012806
}*/

/*
{"dev": "IN_SCAN_1",
 "date": "2023-03-01 07:25:15.211",
 "scan_volume": 1.0372519493103027,
        "plate": "BCY8356", "height": 2.4196081161499023, "width": 2.9600000381469727, "length": 13.75999927520752, "trailer_plate": "RDTB2218", "delivery_note": 10000012806}
*/
