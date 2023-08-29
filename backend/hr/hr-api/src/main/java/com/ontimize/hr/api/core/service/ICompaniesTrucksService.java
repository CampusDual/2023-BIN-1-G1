package com.ontimize.hr.api.core.service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

import java.util.List;
import java.util.Map;

public interface ICompaniesTrucksService {
        public EntityResult companyTrucksQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException;
        public EntityResult companyTrucksInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException;
        public EntityResult companyTrucksUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException;
        public EntityResult companyTrucksDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException;

}
