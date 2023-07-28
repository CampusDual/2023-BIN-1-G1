package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

@Repository("PlatesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/PlatesDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class PlatesDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_PLATE = "id_plate";
    public static final String ATTR_PLATE_NUMBER = "plate_number";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            PlatesDao.ATTR_ID_PLATE,
            PlatesDao.ATTR_PLATE_NUMBER
    );
}