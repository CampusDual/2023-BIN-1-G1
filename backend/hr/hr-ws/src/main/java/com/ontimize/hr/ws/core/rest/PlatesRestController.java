package com.ontimize.hr.ws.core.rest;



import com.ontimize.hr.api.core.service.ITravelsService;
import com.ontimize.hr.model.core.dao.*;
import com.ontimize.hr.model.core.service.PlatesService;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.services.user.UserInformation;
import org.apache.el.lang.ExpressionBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.IPlatesService;
import com.ontimize.jee.server.rest.ORestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/plates")
public class PlatesRestController extends ORestController<IPlatesService> {

    @Autowired
    private IPlatesService plateService;

    @Autowired
    private ITravelsService travelService;

    @Override
    public IPlatesService getService() {
        return this.plateService;
    }

    public ITravelsService getServiceTravels() {
        return this.travelService;
    }
}
