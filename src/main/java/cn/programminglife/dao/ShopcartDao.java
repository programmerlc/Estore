package cn.programminglife.dao;
import cn.programminglife.bean.Shopcart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-15-19:31
 */
@Repository
public interface ShopcartDao {
    @Select("SELECT PRODUCT_ID,PRODUCT_NUM FROM SHOPCART WHERE USER_ID=#{user_id}")
    public List<Shopcart> findAllShopcartByUid(int user_id);

    @Select("SELECT PRODUCT_ID,USER_ID FROM SHOPCART WHERE PRODUCT_ID=#{product_id} AND USER_ID=#{user_id}")
    public Shopcart findShopcart(Shopcart shopcart);

    @Select("SELECT PRODUCT_NUM FROM SHOPCART WHERE PRODUCT_ID=#{product_id} AND USER_ID=#{user_id}")
    public int findProductNumByShopcart(Shopcart shopcart);

    @Insert("INSERT INTO SHOPCART(PRODUCT_ID,PRODUCT_NUM,USER_ID) VALUES(#{product_id},#{product_num},#{user_id})")
    public void addToShopcart(Shopcart shopcart);

    @Insert("UPDATE SHOPCART SET PRODUCT_NUM=#{product_num} WHERE USER_ID=#{user_id}")
    public void updateShopcart(Shopcart shopcart);

    @Delete("DELETE FROM SHOPCART WHERE PRODUCT_ID=#{product_id} AND USER_ID=#{user_id}")
    public void deleteShopCartByPid(@Param("product_id") int product_id,@Param("user_id") int user_id);

    @Delete("DELETE FROM SHOPCART WHERE USER_ID=#{user_id}")
    public void deleteShopCartByUid(int user_id);
}
