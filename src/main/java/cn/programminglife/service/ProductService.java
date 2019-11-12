package cn.programminglife.service;

import cn.programminglife.bean.Product;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-13-0:14
 */
public interface ProductService {
    public List<Product> findAllProducts();

    public List<Product> findProductByCateId(int category_id);

    public Product findProductByTitle(String title);

    public List<Product> findProducts(int count);

    public Product findProductById(int id);
}
