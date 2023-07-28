package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface IPlatesService {
    // EJEMPLO
    public EntityResult plateQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult plateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult plateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult plateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}
