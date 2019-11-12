package cn.programminglife.service;

import cn.programminglife.bean.User;

/**
 * @author programmerlc
 * @create 2019-10-10-11:44
 */
public interface UserService {
    //登录逻辑，利用用户输入的用户名和密码到数据库中查询是否存在满足的用户
    public User login(String username,String password);

    //判断用户名是否存在
    public String judgeUsername(String username);

    //注册逻辑，根据用户输入的信息数据向数据库中添加用户
    public void register(User user);

    //更改用户状态
    public void changeStatus(int id,int status);
}
