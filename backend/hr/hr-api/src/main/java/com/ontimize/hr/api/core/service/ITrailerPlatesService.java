package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ITrailerPlatesService {
    // EJEMPLO
    public EntityResult trailerPlateQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult trailerPlateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult trailerPlateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult trailerPlateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}