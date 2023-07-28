package com.ontimize.hr.ws.core.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.IDeliveryNotesService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/deliverynotes")
public class DeliveryNotesRestController extends ORestController<IDeliveryNotesService> {

    @Autowired
    private IDeliveryNotesService deliveryNotesService;

    @Override
    public IDeliveryNotesService getService() {
        return this.deliveryNotesService;
    }
}
