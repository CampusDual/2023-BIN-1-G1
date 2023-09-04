package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.hr.api.core.service.ICompaniesService;
import com.ontimize.hr.model.core.dao.CompaniesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.common.security.PermissionsProviderSecured;

@Service("CompaniesService")
@Lazy
public class CompaniesService implements ICompaniesService {
    @Autowired private CompaniesDao companiesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyGetWithNumTravelsQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.companiesDao, keyMap, attrList, CompaniesDao.QUERY_GET_WITH_NUM_TRAVELS);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyGetPlatesCompanyQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.companiesDao, keyMap, attrList, CompaniesDao.QUERY_GET_PLATES_COMPANY);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.companiesDao, keyMap, attrList);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.companiesDao, attrMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.companiesDao, attrMap, keyMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.companiesDao, keyMap);
    }

}