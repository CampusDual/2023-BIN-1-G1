package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.hr.model.core.dao.PlatesDao;
import com.ontimize.hr.model.core.dao.TravelsDao;
import com.ontimize.jee.common.security.PermissionsProviderSecured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IPlatesService;
import com.ontimize.hr.model.core.dao.DevicesDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("PlatesService")
@Lazy
public class PlatesService implements IPlatesService {
    @Autowired private PlatesDao platesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult userPlatesQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.platesDao, keyMap, attrList, platesDao.GET_USER_PLATES);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult plateQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.platesDao, keyMap, attrList);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult plateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.platesDao, attrMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult plateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.platesDao, attrMap, keyMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult plateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.platesDao, keyMap);
    }

}