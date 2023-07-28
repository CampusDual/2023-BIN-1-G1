package com.ontimize.hr.ws.core.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IMeasurementsService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/measurements")
public class MeasurementsRestController extends ORestController<IMeasurementsService> {

    @Autowired
    private IMeasurementsService measurementService;

    @Override
    public IMeasurementsService getService() {
        return this.measurementService;
    }
}
