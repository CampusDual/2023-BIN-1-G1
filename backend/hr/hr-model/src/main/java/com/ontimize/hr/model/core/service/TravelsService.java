package com.ontimize.hr.model.core.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ontimize.hr.api.core.service.ITravelsService;
import com.ontimize.hr.model.core.dao.*;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.transaction.annotation.Transactional;

@Service("TravelsService")
@Lazy
public class TravelsService implements ITravelsService {
    @Autowired private TravelsDao travelsDao;
    @Autowired private PlatesService platesService;
    @Autowired private TrailerPlatesService trailerPlatesService;
    @Autowired private DeliveryNotesService deliverynotesService;
    @Autowired private DevicesService devicesService;
    @Autowired private DefaultOntimizeDaoHelper daoHelper;


    @Override
    public EntityResult travelQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        EntityResult et =  this.daoHelper.query(this.travelsDao, keyMap, attrList, TravelsDao.QUERY_GET);
        return et;
    }

    @Override
    public EntityResult travelUpdate(Map<String, Object> attrMap, Map<String, Object> keyMap)
            throws OntimizeJEERuntimeException {
        Map <String, Object> nonTravelData = obtainNonRelatedData(attrMap,
                TravelsDao.ATTR_ID_DEV_OUT,
                TravelsDao.ATTR_ID_PLATE,
                TravelsDao.ATTR_ID_TRAILER_PLATE,
                TravelsDao.ATTR_ID_DELIVERY_NOTE
        );
        //Introducimos los campos modificados con los ids en el attrMap.
        attrMap.putAll(this.updateNonRelatedData(nonTravelData));
        return this.daoHelper.update(this.travelsDao, attrMap, keyMap);
    }

    @Override
    public EntityResult travelDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.travelsDao, keyMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntityResult travelInsert(Map<String, Object> attrMap) throws OntimizeJEERuntimeException {
        attrMap.get("calculated_volume");
        Map <String, Object> nonTravelData = obtainNonRelatedData(attrMap,
                TravelsDao.ATTR_ID_DEV_IN,
                TravelsDao.ATTR_ID_PLATE,
                TravelsDao.ATTR_ID_TRAILER_PLATE,
                TravelsDao.ATTR_ID_DELIVERY_NOTE
        );
        //Introducimos los campos modificados con los ids en el attrMap.
        attrMap.putAll(this.insertNonRelatedData(nonTravelData));
        return this.daoHelper.insert(this.travelsDao, attrMap);
    }

    private Map<String, Object> obtainNonRelatedData(Map<String, Object> attrMap, String... attrToExclude){
        HashMap <String,Object> nonRelateData = new HashMap<>();
        for(String attr : attrToExclude){
            if(attrMap.containsKey(attr)){
                nonRelateData.put(attr, attrMap.remove(attr));
            }
        }
        return nonRelateData;
    }

    private Map<String,Object> insertNonRelatedData(Map<String, Object> inputMap){
        Map<String, Object> attrMap = new HashMap<>(inputMap);

        for(Map.Entry<String, Object>entry : attrMap.entrySet()){
            Map<String, Object> data = new HashMap<>();
            List<String> attr = new ArrayList<>();
            EntityResult toret, query;

            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_DEV_IN)) {
                data.put(DevicesDao.ATTR_DEVICE_NAME, entry.getValue());
                attr.add(DevicesDao.ATTR_ID_DEV);
                query = this.devicesService.deviceQuery(data,attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(DevicesDao.ATTR_ID_DEV));
                } else {
                    toret = this.devicesService.deviceInsert(data);
                    entry.setValue(toret.get(DevicesDao.ATTR_ID_DEV));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_PLATE)) {
                data.put(PlatesDao.ATTR_PLATE_NUMBER, entry.getValue());
                attr.add(PlatesDao.ATTR_ID_PLATE);
                query = this.platesService.plateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(PlatesDao.ATTR_ID_PLATE));
                }else{
                    toret = this.platesService.plateInsert(data);
                    entry.setValue(toret.get(PlatesDao.ATTR_ID_PLATE));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_TRAILER_PLATE)) {
                data.put(TrailerPlatesDao.ATTR_TRAILER_PLATE_NUMBER, entry.getValue());
                attr.add(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE);
                query = this.trailerPlatesService.trailerPlateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE));
                } else {
                    toret = this.trailerPlatesService.trailerPlateInsert(data);
                    entry.setValue(toret.get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_DELIVERY_NOTE)) {
                data.put(DeliveryNotesDao.ATTR_DELIVERY_NAME, entry.getValue());
                attr.add(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
                query = this.deliverynotesService.deliverynotesQuery(data, attr);
                if(query.calculateRecordNumber() > 0){
                    entry.setValue(query.getRecordValues(0).get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE));
                }else {
                    toret = this.deliverynotesService.deliverynotesInsert(data);
                    entry.setValue(toret.get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE));
                }
            }
        }

        return attrMap;
    }

    private Map<String,Object> updateNonRelatedData(Map<String, Object> inputMap){
        Map<String, Object> attrMap = new HashMap<>(inputMap);

        for(Map.Entry<String, Object>entry : attrMap.entrySet()){
            Map<String, Object> data = new HashMap<>();
            List<String> attr = new ArrayList<>();
            EntityResult toret, query;

            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_DEV_OUT)) {
                data.put(DevicesDao.ATTR_DEVICE_NAME, entry.getValue());
                attr.add(DevicesDao.ATTR_ID_DEV);
                query = this.devicesService.deviceQuery(data,attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(DevicesDao.ATTR_ID_DEV));
                } else {
                    toret = this.devicesService.deviceInsert(data);
                    entry.setValue(toret.get(DevicesDao.ATTR_ID_DEV));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_PLATE)) {
                data.put(PlatesDao.ATTR_PLATE_NUMBER, entry.getValue());
                attr.add(PlatesDao.ATTR_ID_PLATE);
                query = this.platesService.plateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(PlatesDao.ATTR_ID_PLATE));
                }else{
                    toret = this.platesService.plateInsert(data);
                    entry.setValue(toret.get(PlatesDao.ATTR_ID_PLATE));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_TRAILER_PLATE)) {
                data.put(TrailerPlatesDao.ATTR_TRAILER_PLATE_NUMBER, entry.getValue());
                attr.add(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE);
                query = this.trailerPlatesService.trailerPlateQuery(data, attr);
                if(query.calculateRecordNumber() > 0 ) {
                    entry.setValue(query.getRecordValues(0).get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE));
                } else {
                    toret = this.trailerPlatesService.trailerPlateInsert(data);
                    entry.setValue(toret.get(TrailerPlatesDao.ATTR_ID_TRAILER_PLATE));
                }
            }
            if(entry.getKey().equalsIgnoreCase(TravelsDao.ATTR_ID_DELIVERY_NOTE)) {
                data.put(DeliveryNotesDao.ATTR_DELIVERY_NAME, entry.getValue());
                attr.add(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE);
                query = this.deliverynotesService.deliverynotesQuery(data, attr);
                if(query.calculateRecordNumber() > 0){
                    entry.setValue(query.getRecordValues(0).get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE));
                }else {
                    toret = this.deliverynotesService.deliverynotesInsert(data);
                    entry.setValue(toret.get(DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE));
                }
            }
        }

        return attrMap;
    }
}

/*  Measurements-Delivery Measurements-Delivery
*   1 mID_In mID_Out
*
* */