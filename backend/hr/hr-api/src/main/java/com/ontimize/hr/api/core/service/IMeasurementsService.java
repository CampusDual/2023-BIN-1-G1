package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IMeasurementsService {
    // EJEMPLO
    public EntityResult measurementQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult measurementInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult measurementUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult measurementDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}