package com.ontimize.hr.model.core.dao;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;

@Repository("EjemploDao")
@Lazy
@ConfigurationFile(configurationFile = "dao/EjemploDao.xml", configurationFilePlaceholder = "dao/placeholders.properties")
public class EjemploDao extends OntimizeJdbcDaoSupport {

    public static final String ATTR_ID_EJEMPLO = "id_ejemplo";
    public static final String ATTR_VALOR = "valor";
}
