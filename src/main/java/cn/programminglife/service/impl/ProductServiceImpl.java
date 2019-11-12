package cn.programminglife.service.impl;

import cn.programminglife.bean.Product;
import cn.programminglife.dao.ProductDao;
import cn.programminglife.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-14-0:33
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAllProducts() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findProductByCateId(int category_id) {
        return null;
    }

    @Override
    public Product findProductByTitle(String title) {
        return null;
    }

    @Override
    public List<Product> findProducts(int count) {
        List<Product> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(productDao.findProductById(i));
        }
        return list;
    }

    @Override
    public Product findProductById(int id) {
        return productDao.findProductById(id);
    }


}
