package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;

@Repository("TravelsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/TravelsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TravelsDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_TRAVEL = "id_travel";
    public static final String ATTR_ID_DEV_IN = "id_dev_in";
    public static final String ATTR_ID_DEV_OUT = "id_dev_out";
    public static final String ATTR_DATETIME_IN = "datetime_in";
    public static final String ATTR_DATETIME_OUT = "datetime_out";
    public static final String ATTR_SCAN_VOLUME_IN = "scan_volume_in";
    public static final String ATTR_SCAN_VOLUME_OUT = "scan_volume_out";
    public static final String ATTR_CALCULATED_VOLUME = "calculated_volume";
    public static final String ATTR_HEIGHT = "height";
    public static final String ATTR_WIDTH = "width";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_ID_PLATE = "id_plate";
    public static final String ATTR_ID_TRAILER_PLATE = "id_trailer_plate";
    public static final String ATTR_ID_DELIVERY_NOTE = "id_delivery_note";

    public static final String QUERY_GET_STOCK = "query_get_stock";
    public static final String QUERY_GET_BALANCE = "query_get_balance";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            TravelsDao.ATTR_ID_TRAVEL,
            TravelsDao.ATTR_ID_DEV_IN,
            TravelsDao.ATTR_ID_DEV_OUT,
            TravelsDao.ATTR_DATETIME_IN,
            TravelsDao.ATTR_DATETIME_OUT,
            TravelsDao.ATTR_SCAN_VOLUME_IN,
            TravelsDao.ATTR_SCAN_VOLUME_OUT,
            TravelsDao.ATTR_CALCULATED_VOLUME,
            TravelsDao.ATTR_HEIGHT,
            TravelsDao.ATTR_WIDTH,
            TravelsDao.ATTR_LENGTH,
            TravelsDao.ATTR_ID_PLATE,
            TravelsDao.ATTR_ID_TRAILER_PLATE,
            TravelsDao.ATTR_ID_DELIVERY_NOTE
    );
}
