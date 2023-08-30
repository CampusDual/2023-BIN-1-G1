package com.ontimize.hr.ws.core.rest;




import com.ontimize.hr.api.core.service.ICompaniesService;
import com.ontimize.hr.api.core.service.IDeliveryNotesService;
import com.ontimize.hr.api.core.service.IPlatesService;
import com.ontimize.hr.model.core.dao.CompaniesDao;
import com.ontimize.hr.model.core.dao.DeliveryNotesDao;
import com.ontimize.hr.model.core.dao.PlatesDao;
import com.ontimize.jee.common.dto.EntityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.ontimize.hr.api.core.service.ICompaniesTrucksService;
import com.ontimize.jee.server.rest.ORestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/companiesTrucks")
public class CompaniesTrucksRestController extends ORestController<ICompaniesTrucksService> {

    @Autowired
    private ICompaniesTrucksService companiesTrucksService;
    @Autowired
    private ICompaniesService companiesService;
    @Autowired
    private IPlatesService platesService;

    @Override
    public ICompaniesTrucksService getService() {
        return this.companiesTrucksService;
    }

    @RequestMapping( value="/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insertData(@RequestBody Map<String,Object> body) throws ParseException {
        ResponseEntity<String> re = null;

        Object id_plate = getPlate(body.get("plate_number"));

        if(id_plate == null){
            re = new ResponseEntity<String>("CompanyTrucks Insert OK",
                    HttpStatus.CREATED);
        }else{
            re = new ResponseEntity<String>("El plate ya exíste en esa compañía",
                    HttpStatus.BAD_REQUEST);
        }
        return re;
    }

    public Object getPlate(Object plate) {
        HashMap<String, Object> keyMap = new HashMap<>();
        List<String> attr = new ArrayList<>();
        keyMap.put(PlatesDao.ATTR_PLATE_NUMBER, plate);
        attr.add(PlatesDao.ATTR_ID_PLATE);

        EntityResult et = platesService.plateQuery(keyMap, attr);
        return et.getRecordValues(0).get(PlatesDao.ATTR_ID_PLATE);
    }
}













