package cn.programminglife.controller;
import cn.programminglife.bean.OrderItem;
import cn.programminglife.bean.Product;
import cn.programminglife.bean.User;
import cn.programminglife.service.OrderService;
import cn.programminglife.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author programmerlc
 * @create 2019-10-18-9:51
 */
@Controller
public class OrderController {

    private Map<Product,Integer> map;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/order")
    @ResponseBody
    public String order(String info, HttpSession session){
        String[] shops = info.trim().split(" ");
        OrderItem orderItem;
        User user =(User) session.getAttribute("user");
        int user_id = user.getId();
        for (int i = 0; i < shops.length; i+=2) {
            orderItem = new OrderItem();
            orderItem.setFororder(1);
            orderItem.setUser_id(user_id);
            orderItem.setProduct_id(Integer.parseInt(shops[i].substring(4)));
            orderItem.setProduct_num(Integer.parseInt(shops[i+1].substring(7)));
            orderService.addOrderItem(orderItem);
        }
        return "toorder";
    }

    @RequestMapping("/toorder")
    public String toOrder(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<OrderItem> allOrderItem = orderService.findAllOrderItem(user.getId());
        double sumprice = orderService.calcSumprice(user.getId());
        map = new HashMap<Product,Integer>();
        for (OrderItem orderItem : allOrderItem) {
            map.put(productService.findProductById(orderItem.getProduct_id()),orderItem.getProduct_num());
        }
        request.setAttribute("sumprice",sumprice);
        request.setAttribute("orderItems",map);
        map = null;
        return "order";
    }

}
