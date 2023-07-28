package com.ontimize.hr.ws.core.rest;



import com.ontimize.hr.model.core.service.PlatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.IPlatesService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/plates")
public class PlatesRestController extends ORestController<IPlatesService> {

    @Autowired
    private IPlatesService plateService;

    @Override
    public IPlatesService getService() {
        return this.plateService;
    }
}
