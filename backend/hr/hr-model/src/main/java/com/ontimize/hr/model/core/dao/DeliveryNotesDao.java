package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository("DeliveryNotesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/DeliveryNotesDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class DeliveryNotesDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_DELIVERY_NOTE = "id_delivery_note";
    public static final String ATTR_DELIVERY_NAME = "delivery_name";
    public static final String ATTR_MID_IN = "mId_in";
    public static final String ATTR_MID_OUT = "mId_out";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            DeliveryNotesDao.ATTR_ID_DELIVERY_NOTE,
            DeliveryNotesDao.ATTR_DELIVERY_NAME,
            DeliveryNotesDao.ATTR_MID_IN,
            DeliveryNotesDao.ATTR_MID_OUT
    );
}



