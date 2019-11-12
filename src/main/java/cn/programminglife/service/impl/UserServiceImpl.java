package cn.programminglife.service.impl;

import cn.programminglife.bean.User;
import cn.programminglife.dao.UserDao;
import cn.programminglife.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author programmerlc
 * @create 2019-10-11-20:22
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        if(userDao.findUserByUsername(username)==null){
            return null;
        }
        return userDao.findUserByUsernameAndPass(username, password);
    }

    @Override
    public String judgeUsername(String username) {
        return userDao.findUserByUsername(username);
    }

    @Override
    public void register(User user){
        userDao.addUser(user);
    }

    @Override
    public void changeStatus(int id,int status) {
        userDao.updateStatus(id,status);
    }
}
