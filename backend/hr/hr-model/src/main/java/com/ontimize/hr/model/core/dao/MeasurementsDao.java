package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

@Repository("MeasurementsDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/MeasurementsDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class MeasurementsDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_MEASUREMENT = "id_measurement";
    public static final String ATTR_ID_DEV = "id_dev";
    public static final String ATTR_DATETIME = "datetime";
    public static final String ATTR_SCAN_VOLUME = "scan_volume";
    public static final String ATTR_CALCULATED_VOLUME = "calculated_volume";
    public static final String ATTR_HEIGHT = "height";
    public static final String ATTR_WIDTH = "width";
    public static final String ATTR_LENGTH = "length";
    public static final String ATTR_ID_PLATE = "id_plate";
    public static final String ATTR_ID_TRAILER_PLATE = "id_trailer_plate";
    public static final String ATTR_ID_DELIVERY_NOTE = "id_delivery_note";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            MeasurementsDao.ATTR_ID_MEASUREMENT,
            MeasurementsDao.ATTR_ID_DEV,
            MeasurementsDao.ATTR_DATETIME,
            MeasurementsDao.ATTR_SCAN_VOLUME,
            MeasurementsDao.ATTR_CALCULATED_VOLUME,
            MeasurementsDao.ATTR_HEIGHT,
            MeasurementsDao.ATTR_WIDTH,
            MeasurementsDao.ATTR_LENGTH,
            MeasurementsDao.ATTR_ID_PLATE,
            MeasurementsDao.ATTR_ID_TRAILER_PLATE,
            MeasurementsDao.ATTR_ID_DELIVERY_NOTE
    );
}
