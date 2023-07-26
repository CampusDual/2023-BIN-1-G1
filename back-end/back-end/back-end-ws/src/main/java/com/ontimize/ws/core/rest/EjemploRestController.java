package com.ontimize.ws.core.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.api.core.service.IEjemploService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/ejemplos")
public class EjemploRestController extends ORestController<IEjemploService> {

    @Autowired
    private IEjemploService ejemploService;

    @Override
    public IEjemploService getService() {
        return this.ejemploService;
    }
}
