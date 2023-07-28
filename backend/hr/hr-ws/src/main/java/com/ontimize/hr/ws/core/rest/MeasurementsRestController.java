package com.ontimize.hr.ws.core.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IMeasurementsService;
import com.ontimize.jee.server.rest.ORestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public String insertData(@RequestBody Map<String,Object> body){
        body.get("message");
        List<Integer> lista = (List<Integer>) body.get("list");
        return "HOLA";
    }
}
