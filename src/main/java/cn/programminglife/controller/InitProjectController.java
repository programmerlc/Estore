package cn.programminglife.controller;

import cn.programminglife.bean.Product;
import cn.programminglife.service.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.util.List;

/**
 * @author programmerlc
 * @create 2019-10-14-11:20
 */
public class InitProjectController implements InitializingBean, ServletContextAware {

    @Autowired
    private ProductService productService;

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        if(servletContext.getAttribute("allproducts")==null){
            List<Product> allProducts = productService.findAllProducts();
            if(allProducts!=null&&allProducts.size()>0){
                servletContext.setAttribute("allproducts",allProducts);
            }
        }
    }
}
