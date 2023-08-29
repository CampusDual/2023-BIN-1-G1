package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

@Repository("CompaniesTrucksDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CompaniesTrucksDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CompaniesTrucksDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_COMPANY = "id_company";
    public static final String ATTR_ID_PLATE = "id_plate";

    public static final String QUERTY_GET_NOT_OWNED_PLATES = "get_not_owned_plates";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
            CompaniesTrucksDao.ATTR_ID_COMPANY,
            CompaniesTrucksDao.ATTR_ID_PLATE
    );

}
