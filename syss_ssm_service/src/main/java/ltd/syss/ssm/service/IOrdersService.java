package ltd.syss.ssm.service;

import ltd.syss.ssm.domain.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IOrdersService {
    List<Orders> findAll(int page,int size) throws Exception;


    Orders findById(String id) throws Exception;
}
