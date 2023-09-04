package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.security.PermissionsProviderSecured;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IDevicesService;
import com.ontimize.hr.model.core.dao.DevicesDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("DevicesService")
@Lazy
public class DevicesService implements IDevicesService {
    @Autowired private DevicesDao devicesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult deviceQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.devicesDao, keyMap, attrList);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult deviceInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.devicesDao, attrMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult deviceUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.devicesDao, attrMap, keyMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult deviceDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.devicesDao, keyMap);
    }

}