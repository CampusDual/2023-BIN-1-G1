package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
@Repository("DevicesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/DevicesDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class DevicesDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_DEV = "id_dev";
    public static final String ATTR_DEVICE_NAME = "device_name";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            DevicesDao.ATTR_ID_DEV,
            DevicesDao.ATTR_DEVICE_NAME
    );
}