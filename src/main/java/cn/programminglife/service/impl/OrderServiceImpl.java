package cn.programminglife.service.impl;

import cn.programminglife.bean.OrderItem;
import cn.programminglife.dao.OrderDao;
import cn.programminglife.dao.ProductDao;
import cn.programminglife.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-18-15:30
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public void addOrderItem(OrderItem orderItem) {
        if(orderDao.findOrderItem(orderItem)!=null){
            orderDao.deleteOrderItem(orderItem);
        }
        orderDao.addOrderItem(orderItem);
    }

    @Override
    public List<OrderItem> findAllOrderItem(int owner_id) {
        return orderDao.findAllOrderItem(owner_id,1);
    }

    @Override
    public double calcSumprice(int owner_id) {
        List<OrderItem> allOrderItem = orderDao.findAllOrderItem(owner_id, 1);
        double sumprice = 0;
        for (OrderItem orderItem : allOrderItem) {
            sumprice += (productDao.findPriceByPid(orderItem.getProduct_id())*orderItem.getProduct_num());
        }
        return sumprice;
    }
}
