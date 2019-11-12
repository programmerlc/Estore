package cn.programminglife.controller;

import cn.programminglife.bean.User;
import cn.programminglife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * @author programmerlc
 * @create 2019-10-11-20:17
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/dologin")
    public String login(HttpServletRequest request, HttpServletResponse response, String username, String password, String switch_value){
        if(userService.judgeUsername(username)==null){
            request.setAttribute("login_msg","用户名不存在");
            return "login";
        }
        User user = userService.login(username, password);
        if(user==null){
            request.setAttribute("login_msg","密码输入错误");
            return "login";
        }else{
            if(switch_value!=null&&switch_value.equals("on")){
                Cookie username_cookie = new Cookie("username",username);
                Cookie password_cookie = new Cookie("password",password);
                username_cookie.setMaxAge(3600*240);
                password_cookie.setMaxAge(3600*240);
                response.addCookie(username_cookie);
                response.addCookie(password_cookie);
            }
            user.setStatus(1);
            request.getSession().setAttribute("user",user);
            return "redirect:/";
        }
    }

    @RequestMapping("/doregis")
    public String register(HttpServletRequest request,HttpSession session,User user){
        if(userService.judgeUsername(user.getUsername())!=null){
            request.setAttribute("regis_msg","用户名已存在");
            return "register";
        }
        Random random = new Random();
        user.setHeaderpic_url("https://picsum.photos/id/"+(random.nextInt(100)+1001)+"/300/300");
        user.setStatus(1);
        userService.register(user);
        session.setAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping("/toregis")
    public String toRegis(){
        return "register";
    }

    @RequestMapping("/tologin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        User user =(User) session.getAttribute("user");
        if(user!=null){
            userService.changeStatus(user.getId(),0);
            session.removeAttribute("user");
        }
        return "redirect:/";
    }
}
