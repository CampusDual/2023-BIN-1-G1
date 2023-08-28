package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.hr.api.core.service.ICompaniesService;
import com.ontimize.hr.model.core.dao.CompaniesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("CompaniesService")
@Lazy
public class CompaniesService implements ICompaniesService {
    @Autowired private CompaniesDao companiesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult companyQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.companiesDao, keyMap, attrList);
    }

    @Override
    public EntityResult companyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.companiesDao, attrMap);
    }

    @Override
    public EntityResult companyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.companiesDao, attrMap, keyMap);
    }

    @Override
    public EntityResult companyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.companiesDao, keyMap);
    }

}