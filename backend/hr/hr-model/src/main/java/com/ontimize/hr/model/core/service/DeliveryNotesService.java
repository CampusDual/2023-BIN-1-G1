package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import com.ontimize.hr.model.core.dao.DeliveryNotesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IDeliveryNotesService;
import com.ontimize.hr.model.core.dao.DeliveryNotesDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("DeliveryNotesService")
@Lazy
public class DeliveryNotesService implements IDeliveryNotesService {
    @Autowired private DeliveryNotesDao deliverynotesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult deliverynotesQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.deliverynotesDao, keyMap, attrList);
    }

    @Override
    public EntityResult deliverynotesInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.deliverynotesDao, attrMap);
    }

    @Override
    public EntityResult deliverynotesUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.deliverynotesDao, attrMap, keyMap);
    }

    @Override
    public EntityResult deliverynotesDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.deliverynotesDao, keyMap);
    }

}