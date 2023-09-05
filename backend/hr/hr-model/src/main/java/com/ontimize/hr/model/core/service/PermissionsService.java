package com.ontimize.hr.model.core.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.ontimize.hr.api.core.service.IPermissionService;
import com.ontimize.hr.model.core.dao.TravelsDao;
import com.ontimize.hr.model.core.dao.UserRoleDao;
import com.ontimize.jee.common.dto.EntityResultMapImpl;
import com.ontimize.jee.common.services.user.UserInformation;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;

@Service("PermissionsService")
@Lazy
public class PermissionsService implements IPermissionService {
    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;
    @Autowired private UserRoleDao userRoleDao;
    public final String TRUCK_DRIVER_PERMISSION;
    public final String DEMO_PERMISSION;
    public final String DISTRIBUTOR_PERMISSION;

    private String readFromInputStream(String fileName) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(this.getClass().getClassLoader().getResourceAsStream(fileName))))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        catch (IOException e){
            return "";
        }
        return resultStringBuilder.toString();
    }

    public PermissionsService(){
        try {
            TRUCK_DRIVER_PERMISSION = readFromInputStream("truck_driver_permissions.json");
            DEMO_PERMISSION = readFromInputStream("demo_permissions.json");
            DISTRIBUTOR_PERMISSION = readFromInputStream("distributor_permissions.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntityResult permissionQuery(Map<String, Object> keyMap, List<String> attrList)
            throws OntimizeJEERuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserInformation)authentication.getPrincipal()).getUsername();
        EntityResult e = new EntityResultMapImpl();
        Map<String, String> map = new HashMap<>();
        String role = authentication.getAuthorities().toArray()[0].toString();
        if (role.equals("truck_driver")) {
            map.put("permission", TRUCK_DRIVER_PERMISSION);
            map.put("role", role);
        }
        else if (role.equals("admin")) {
            map.put("permission", DEMO_PERMISSION);
        }
        e.addRecord(map);
        return e;
    }

    @Override
    public EntityResult userRoleQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserInformation)authentication.getPrincipal()).getUsername();
        keyMap.clear();
        keyMap.put("user_", username);

        return this.daoHelper.query(this.userRoleDao, keyMap, attrList, UserRoleDao.QUERY_USER_ROLE);
    }
}
