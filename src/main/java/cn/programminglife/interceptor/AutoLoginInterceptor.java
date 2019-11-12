package cn.programminglife.interceptor;

import cn.programminglife.bean.User;
import cn.programminglife.service.impl.UserServiceImpl;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author programmerlc
 * @create 2019-10-15-10:06
 */
public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            String username = null;
            String password = null;
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                    continue;
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
            if (username != null && password != null) {
                User user = new UserServiceImpl().login(username, password);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                }
            }
        }
        return super.preHandle(request, response, handler);
    }
}
