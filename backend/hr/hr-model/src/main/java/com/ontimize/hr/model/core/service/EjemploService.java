package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IEjemploService;
import com.ontimize.hr.model.core.dao.EjemploDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("EjemploService")
@Lazy
    public class EjemploService implements IEjemploService {
    @Autowired private EjemploDao ejemploDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult ejemploQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.ejemploDao, keyMap, attrList);
    }

    @Override
    public EntityResult ejemploInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.ejemploDao, attrMap);
    }

    @Override
    public EntityResult ejemploUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.ejemploDao, attrMap, keyMap);
    }

    @Override
    public EntityResult ejemploDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.ejemploDao, keyMap);
    }

}

