package ltd.syss.ssm.dao;

import ltd.syss.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysLogDao {

    @Select("select * from syslog")
    @Results({
            @Result(id =true,column = "id",property = "id"),
            @Result(column = "visitTime",property = "visitTime"),
            @Result(column = "ip",property = "ip"),
            @Result(column = "url",property = "url"),
            @Result(column = "executionTime",property = "executionTime"),
            @Result(column = "method",property = "method"),
            @Result(column = "username",property = "username")
    })
    List<SysLog> findAll() throws Exception;

    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method)" +
            " values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog log) throws Exception;
}
