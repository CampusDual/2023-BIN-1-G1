package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface IDeliveryNotesService {
    // Delivery Notes
    public EntityResult deliverynotesQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult deliverynotesInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult deliverynotesUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult deliverynotesDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
}
