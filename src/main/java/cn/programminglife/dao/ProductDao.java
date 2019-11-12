package cn.programminglife.dao;

import cn.programminglife.bean.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-13-0:03
 */
@Repository
public interface ProductDao {

    @Select("SELECT ID,TITLE,PRICE,PNUM,IMG_URL,DESCRIPTION,COLOR,CATEGORY_ID FROM PRODUCT")
    public List<Product> findAll();

    @Select("SELECT ID,TITLE,PRICE,PNUM,IMG_URL,DESCRIPTION,COLOR,CATEGORY_ID FROM PRODUCT WHERE CATEGORY_ID=#{category_id}")
    public List<Product> findProductsByCateId(int category_id);

    @Select("SELECT ID,TITLE,PRICE,PNUM,IMG_URL,DESCRIPTION,COLOR,CATEGORY_ID FROM PRODUCT WHERE ID=#{id}")
    public Product findProductById(int id);

    @Select("SELECT PRICE FROM PRODUCT WHERE ID=#{pid}")
    public double findPriceByPid(int pid);
}
