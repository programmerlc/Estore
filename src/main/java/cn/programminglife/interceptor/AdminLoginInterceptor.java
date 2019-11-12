package cn.programminglife.interceptor;

import cn.programminglife.bean.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author programmerlc
 * @create 2019-10-15-10:34
 */
public class AdminLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user!=null&&(user.getUsername().equals("admin")&&user.getPassword().equals("987654321"))) {
            return super.preHandle(request, response, handler);
        }else {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }
    }
}
