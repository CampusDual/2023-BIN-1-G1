package com.ontimize.hr.ws.core.rest;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.ICompaniesService;
import com.ontimize.jee.server.rest.ORestController;

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