package ltd.syss.ssm.service;

import ltd.syss.ssm.domain.SysLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ISysLogService {
    List<SysLog> findAll() throws Exception;
    void save(SysLog log) throws Exception;
}
