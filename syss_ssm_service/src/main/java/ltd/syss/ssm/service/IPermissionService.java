package ltd.syss.ssm.service;

import ltd.syss.ssm.domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    List<Permission> findOtherPermission(String roleId) throws Exception;
}
