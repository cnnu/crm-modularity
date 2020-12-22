package ltd.syss.ssm.service.Impl;

import ltd.syss.ssm.dao.SysLogDao;
import ltd.syss.ssm.domain.SysLog;
import ltd.syss.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private SysLogDao sysLogDao;
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }

    @Override
    public void save(SysLog log) throws Exception {
        sysLogDao.save(log);
    }


}
