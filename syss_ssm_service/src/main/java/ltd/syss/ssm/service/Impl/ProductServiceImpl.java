package ltd.syss.ssm.service.Impl;

import ltd.syss.ssm.dao.IProductDao;
import ltd.syss.ssm.domain.Product;
import ltd.syss.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional  //事务标注
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao iProductDao;

    @Override
    public List<Product> findAll() throws Exception{
        return iProductDao.findAll();
    }

    @Override
    public void save(Product product)throws Exception {
        iProductDao.save(product);
    }
}
