package com.ontimize.hr.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.IMeasurementsService;
import com.ontimize.hr.model.core.dao.*;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.transaction.annotation.Transactional;

@Service("MeasurementsService")
@Lazy
public class MeasurementsService implements IMeasurementsService {
    @Autowired private MeasurementsDao measurementsDao;
    @Autowired private PlatesService platesService;
    @Autowired private TrailerPlatesService trailerPlatesService;
    @Autowired private DeliveryNotesService deliverynotesService;
    @Autowired private DevicesService devicesService;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;


    @Override
    public EntityResult measurementQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.query(this.measurementsDao, keyMap, attrList);
    }

    @Override
    public EntityResult measurementUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.measurementsDao, attrMap, keyMap);
    }

    @Override
    public EntityResult measurementDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.measurementsDao, keyMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntityResult measurementInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        Map <String, Object> nonMeasurementData = obtainNonRelatedData(attrMap,
                MeasurementsDao.ATTR_ID_DEV,
                MeasurementsDao.ATTR_ID_PLATE,
                MeasurementsDao.ATTR_ID_TRAILER_PLATE,
                MeasurementsDao.ATTR_ID_DELIVERY_NOTE
        );
        //Introducimos los campos modificados con los ids en el attrMap.
        attrMap.putAll(this.insertNonRelatedData(nonMeasurementData));
        return this.daoHelper.insert(this.measurementsDao, attrMap);
    }

    private Map<String, Object> obtainNonRelatedData(Map<String, Object> attrMap, String... attrToExclude){
        HashMap <String,Object> nonRelateData = new HashMap<>();
        for(String attr : attrToExclude){
            if(attrMap.containsKey(attr) && attrMap.get(attr) instanceof String){
                nonRelateData.put(attr, attrMap.remove(attr));
            }
        }
        return nonRelateData;
    }

    private Map<String,Object> insertNonRelatedData(Map<String, Object> inputMap){
        Map<String, Object> attrMap = new HashMap<>(inputMap);

        attrMap.forEach((key,value) -> {
            Map<String, Object> data = new HashMap<>();
            List<String> attr = new ArrayList<>();
            EntityResult toret, query;

            if(key.equalsIgnoreCase(MeasurementsDao.ATTR_ID_DEV)) {
                data.put(DevicesDao.ATTR_DEVICE_NAME, value);
                attr.add(DevicesDao.ATTR_ID_DEV);
                query = this.devicesService.deviceQuery(data,attr);
                if(query.calculateRecordNumber() > 0 ) {
                    value = query.getRecordValues(0).get(DevicesDao.ATTR_ID_DEV);
                } else {
                    toret = this.devicesService.deviceInsert(data);
                    value = toret.get(DevicesDao.ATTR_ID_DEV);
                }
            }
            if(key.equalsIgnoreCase(MeasurementsDao.ATTR_ID_PLATE)) {
                data.put(PlatesDao.ATTR_PLATE_NUMBER, value);
                attr.add(PlatesDao.ATTR_ID_PLATE);
                query = this.platesService.plateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    value = query.getRecordValues(0).get(PlatesDao.ATTR_ID_PLATE);
                }else{
                    toret = this.platesService.plateInsert(data);
                    value = toret.get(PlatesDao.ATTR_ID_PLATE);
                }
            }
            if(key.equalsIgnoreCase(MeasurementsDao.ATTR_ID_TRAILER_PLATE)) {
                data.put(TrailerPlatesDao.ATTR_TRAILER_PLATE_NUMBER, value);
                attr.add(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE);
                query = this.trailerPlatesService.trailerPlateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    value = query.getRecordValues(0).get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE);
                } else {
                    toret = this.trailerPlatesService.trailerPlateInsert(data);
                    value = toret.get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE);
                }
            }
            if(key.equalsIgnoreCase(MeasurementsDao.ATTR_ID_DELIVERY_NOTE)) {
                data.put(DeliveryNotesDao.ATTR_DELIVERY_NAME, value);
                attr.add(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
                query = this.deliverynotesService.deliverynotesQuery(data, attr);
                if(query.calculateRecordNumber() > 0){
                    value = query.getRecordValues(0).get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
                }else {
                    toret = this.deliverynotesService.deliverynotesInsert(data);
                    value = toret.get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
                }
            }
            attrMap.put(key,value);
        });

        return attrMap;
    }
}
