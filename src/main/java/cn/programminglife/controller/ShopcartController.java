package cn.programminglife.controller;

import cn.programminglife.bean.Product;
import cn.programminglife.bean.Shopcart;
import cn.programminglife.bean.User;
import cn.programminglife.service.ProductService;
import cn.programminglife.service.ShopcartService;
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
 * @create 2019-10-15-19:57
 */
@Controller
public class ShopcartController {

    private Map<Product,Integer> map;

    @Autowired
    private ShopcartService shopcartService;

    @Autowired
    private ProductService productService;

    @RequestMapping("/addtoshopcar")
    @ResponseBody
    public String addToShopCar(String pid, String buynum, HttpSession session){
        User user = (User)session.getAttribute("user");
        shopcartService.addToShopcart(new Shopcart(Integer.parseInt(pid),Integer.parseInt(buynum),user.getId()));
        return "";
    }

    @RequestMapping("/myshopcar")
    public String myShopCar(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("user");
        List<Shopcart> allShopcart = shopcartService.findAllShopcartByUid(user.getId());
        map = new HashMap<Product, Integer>();
        if(allShopcart!=null && allShopcart.size() > 0){
            for (Shopcart shopcart : allShopcart) {
                map.put(productService.findProductById(shopcart.getProduct_id()),shopcart.getProduct_num());
            }
        }
        request.setAttribute("allShopcart",map);
        map = null;
        return "shopcart";
    }

    @RequestMapping("/deleteShopcart")
    @ResponseBody
    public String deleteShopcart(String shopid, HttpSession session){
        User user = (User)session.getAttribute("user");
        shopcartService.deleteShopcartById(Integer.parseInt(shopid),user.getId());
        return "";
    }

    @RequestMapping("/clearShopcart")
    @ResponseBody
    public String clearShopcart(String user_id){
        shopcartService.clearShopcartByUid(Integer.parseInt(user_id));
        return "";
    }
}
