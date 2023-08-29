package com.ontimize.hr.ws.core.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.ICompaniesService;
import com.ontimize.jee.server.rest.ORestController;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/companies")
public class CompaniesRestController extends ORestController<ICompaniesService> {

    @Autowired
    private ICompaniesService companiesService;

    @Override
    public ICompaniesService getService() {
        return this.companiesService;
    }
}