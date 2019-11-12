package cn.programminglife.controller;

import cn.programminglife.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author programmerlc
 * @create 2019-10-14-14:47
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/todetails")
    public String todetails(String pid, HttpServletRequest request){
        request.setAttribute("pid",pid);
        return "details";
    }
}
