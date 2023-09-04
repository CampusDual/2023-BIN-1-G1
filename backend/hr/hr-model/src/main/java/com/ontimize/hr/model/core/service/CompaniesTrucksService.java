package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.hr.api.core.service.ICompaniesTrucksService;
import com.ontimize.hr.model.core.dao.CompaniesTrucksDao;
import com.ontimize.hr.model.core.dao.TravelsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import com.ontimize.jee.common.security.PermissionsProviderSecured;

@Service("CompaniesTrucksService")
@Lazy
public class CompaniesTrucksService implements ICompaniesTrucksService {
    @Autowired private CompaniesTrucksDao companiesTrucksDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException{
            return this.daoHelper.query(this.companiesTrucksDao, keyMap, attrList);
    }
    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksGetNotOwnedPlatesQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException{
        return this.daoHelper.query(this.companiesTrucksDao, keyMap, attrList, CompaniesTrucksDao.QUERY_GET_NOT_OWNED_PLATES);
    }
    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksGetBestBuyersQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException{
        return this.daoHelper.query(this.companiesTrucksDao, keyMap, attrList, CompaniesTrucksDao.QUERY_GET_BEST_BUYERS);
    }
    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksGetBestSellersQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException{
        return this.daoHelper.query(this.companiesTrucksDao, keyMap, attrList, CompaniesTrucksDao.QUERY_GET_BEST_SELLERS);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.companiesTrucksDao, attrMap);
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return null;
    }

    @Override
    @Secured({ PermissionsProviderSecured.SECURED })
    public EntityResult companyTrucksDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return null;
    }

}
