package com.ontimize.hr.api.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

public interface ITravelsService {
    // EJEMPLO
    public EntityResult travelQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult travelInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
    public EntityResult travelUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult travelDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
    public EntityResult travelFullQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult travelGetBalanceQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult travelGetStockQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult travelGetTrucksQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
    public EntityResult restrictedTravelsByUserQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;

}