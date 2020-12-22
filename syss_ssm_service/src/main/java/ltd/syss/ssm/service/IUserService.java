package ltd.syss.ssm.service;

import ltd.syss.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    UserInfo findById(String id) throws Exception;

    List<UserInfo> findAll() throws Exception;

    void save(UserInfo userInfo) throws Exception;

    void addRoleToUser(String userId, String[] roleIds) throws Exception;
}
