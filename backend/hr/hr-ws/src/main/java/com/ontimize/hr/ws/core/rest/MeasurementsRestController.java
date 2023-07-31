package com.ontimize.hr.ws.core.rest;


import com.ontimize.hr.model.core.dao.MeasurementsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IMeasurementsService;
import com.ontimize.jee.server.rest.ORestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.*;

import java.text.SimpleDateFormat;

@RestController
@RequestMapping("/measurements")
public class MeasurementsRestController extends ORestController<IMeasurementsService> {

    @Autowired
    private IMeasurementsService measurementService;

    @Override
    public IMeasurementsService getService() {
        return this.measurementService;
    }

    @RequestMapping( value="/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insertData(@RequestBody Map<String,Object> body) throws ParseException {
        //Hay que depurar todas la columnas ID
        Object dev = body.remove("dev");
        body.put(MeasurementsDao.ATTR_ID_DEV, dev);
        Object plate = body.remove("plate");
        body.put(MeasurementsDao.ATTR_ID_PLATE, plate);
        Object trailer = body.remove("trailer_plate");
        body.put(MeasurementsDao.ATTR_ID_TRAILER_PLATE, trailer);
        Object deliveryNote = body.remove("delivery_note");
        body.put(MeasurementsDao.ATTR_ID_DELIVERY_NOTE, deliveryNote);

        String timestampString = (String) body.get("date"); // Aquí debes poner tu timestamp en formato de cadena
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Timestamp date = new Timestamp(dateFormat.parse(timestampString).getTime());
        body.remove("date");
        body.put("datetime", date);
        measurementService.measurementInsert(body);
        return  new ResponseEntity<String>("Measurement Insert OK",  HttpStatus.CREATED);
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
