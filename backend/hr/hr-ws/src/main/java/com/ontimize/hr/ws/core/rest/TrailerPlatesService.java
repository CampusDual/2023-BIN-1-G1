package com.ontimize.hr.ws.core.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ontimize.hr.api.core.service.ITrailerPlatesService;
import com.ontimize.jee.server.rest.ORestController;

@RestController
@RequestMapping("/trailerplates")
public class TrailerPlatesService extends ORestController<ITrailerPlatesService> {

    @Autowired
    private ITrailerPlatesService trailerplateService;

    @Override
    public ITrailerPlatesService getService() {
        return this.trailerplateService;
    }
}

