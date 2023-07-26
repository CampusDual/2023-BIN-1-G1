package com.ontimize.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IEjemploService {
    // EJEMPLO
    public EntityResult ejemploQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult ejemploInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult ejemploUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult ejemploDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}

