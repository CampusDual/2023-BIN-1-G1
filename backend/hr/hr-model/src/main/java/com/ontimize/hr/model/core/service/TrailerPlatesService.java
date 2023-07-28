package com.ontimize.hr.model.core.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.ITrailerPlatesService;
import com.ontimize.hr.model.core.dao.TrailerPlatesDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;

@Service("DeliveryNotesService")
@Lazy
public class TrailerPlatesService implements ITrailerPlatesService {
    @Autowired private TrailerPlatesDao trailerPlatesDao;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult trailerPlateQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.trailerPlatesDao, keyMap, attrList);
    }

    @Override
    public EntityResult trailerPlateInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.trailerPlatesDao, attrMap);
    }

    @Override
    public EntityResult trailerPlateUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.trailerPlatesDao, attrMap, keyMap);
    }

    @Override
    public EntityResult trailerPlateDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.trailerPlatesDao, keyMap);
    }

}