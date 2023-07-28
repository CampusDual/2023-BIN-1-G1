package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

@Repository("TrailerPlatesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/TrailerPlatesDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class TrailerPlatesDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_TRAILER_PLATE = "id_trailer_plate";
    public static final String ATTR_TRAILER_PLATE_NUMBER = "trailer_plate_number";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            TrailerPlatesDao.ATTR_ID_TRAILER_PLATE,
            TrailerPlatesDao.ATTR_TRAILER_PLATE_NUMBER
    );
}