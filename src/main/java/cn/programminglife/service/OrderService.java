package cn.programminglife.service;

import cn.programminglife.bean.OrderItem;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-18-14:51
 */
public interface OrderService {

    public void addOrderItem(OrderItem orderItem);

    public List<OrderItem> findAllOrderItem(int owner_id);

    public double calcSumprice(int owner_id);
}
