package com.ontimize.hr.model.core.dao;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Arrays;
import java.util.Locale;

@Repository("CompaniesDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/CompaniesDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class CompaniesDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_COMPANY = "id_company";
    public static final String ATTR_COMPANY_NAME = "company_name";
    public static final String ATTR_COMPANY_EMAIL = "company_email";
    public static final String ATTR_COMPANY_DIRECTION_STREET = "company_direction_street";
    public static final String ATTR_COMPANY_DIRECTION_CIP = "company_direction_cip";
    public static final String ATTR_COMPANY_DIRECTION_COUNTRY = "company_direction_city";
    public static final String ATTR_COMPANY_DIRECTION_PHONE = "company_direction_country";
    public static final String ATTR_COMPANY_START_DATE = "company_start_date";
    public static final String ATTR_COMPANY_LOGO = "company_logo";
    public static final String QUERY_GET_WITH_NUM_TRAVELS = "get_with_num_travels";
    public static final String QUERY_GET_PLATES_COMPANY = "get_Plates_Company";

    public static final List<String> ALL_COLUMNS = Arrays.asList(
           CompaniesDao.ATTR_ID_COMPANY,
           CompaniesDao.ATTR_COMPANY_NAME,
           CompaniesDao.ATTR_COMPANY_EMAIL,
           CompaniesDao.ATTR_COMPANY_DIRECTION_STREET,
           CompaniesDao.ATTR_COMPANY_DIRECTION_CIP,
           CompaniesDao.ATTR_COMPANY_DIRECTION_COUNTRY,
           CompaniesDao.ATTR_COMPANY_DIRECTION_PHONE,
           CompaniesDao.ATTR_COMPANY_START_DATE,
           CompaniesDao.ATTR_COMPANY_LOGO
    );
}