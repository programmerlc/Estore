package cn.programminglife.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author programmerlc
 * @create 2019-10-15-9:46
 */
public class ToLoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")!=null) {
            response.sendRedirect(request.getContextPath()+"/");
            return false;
        }else {
            return super.preHandle(request, response, handler);
        }
    }
}
