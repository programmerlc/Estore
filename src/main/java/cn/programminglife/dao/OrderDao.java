package cn.programminglife.dao;
import cn.programminglife.bean.Order;
import cn.programminglife.bean.OrderItem;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-18-14:52
 */
@Repository
public interface OrderDao {
    @Select("SELECT ID,PRICE,RECEIVER_NAME,RECEIVER_PHONE,RECEIVER_ADDRESS,PAY_STATUS,ORDERTIME,USER_ID FROM ORDER WHERE USER_ID=#{owner_id}")
    public List<Order> findAllOrder(int owner_id);

    @Insert("INSERT INTO SHOPCART(PRODUCT_ID,PRODUCT_NUM,USER_ID,FORORDER) VALUES(#{product_id},#{product_num},#{user_id},#{fororder})")
    public void addOrderItem(OrderItem orderItem);

    @Select("SELECT PRODUCT_ID,PRODUCT_NUM,USER_ID,FORORDER FROM SHOPCART WHERE USER_ID=#{owner_id} AND FORORDER=#{fororder}")
    public List<OrderItem> findAllOrderItem(@Param("owner_id") int owner_id,@Param("fororder") int fororder);

    @Delete("DELETE FROM SHOPCART WHERE PRODUCT_ID=#{product_id} AND USER_ID=#{user_id} AND FORORDER=#{fororder}")
    public void deleteOrderItem(OrderItem orderItem);

    @Select("SELECT PRODUCT_ID,PRODUCT_NUM,USER_ID,FORORDER FROM SHOPCART WHERE PRODUCT_ID=#{product_id} AND USER_ID=#{user_id} AND FORORDER=#{fororder}")
    public OrderItem findOrderItem(OrderItem orderItem);
}
