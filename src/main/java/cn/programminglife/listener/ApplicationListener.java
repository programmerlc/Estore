package cn.programminglife.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author programmerlc
 * @create 2019-10-14-11:26
 */
@WebListener
public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext application = sce.getServletContext();
        if(application.getAttribute("allproducts")!=null){
            application.removeAttribute("allproducts");
        }

    }
}
