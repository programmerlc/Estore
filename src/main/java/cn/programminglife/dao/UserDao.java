package cn.programminglife.dao;

import cn.programminglife.bean.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author programmerlcS
 * @create 2019-10-10-0:46
 */
@Repository
public interface UserDao {
    @Select("SELECT ID,HEADERPIC_URL,NICKNAME,USERNAME,PASSWORD,ROLE,STATUS,SEX,BIRTHDAY,PHONE,EMAIL,ADDRESS,ACTIVECODE,UPDATETIME FROM USER")
    public List<User> findAll();

    @Select("SELECT ID,HEADERPIC_URL,NICKNAME,USERNAME,PASSWORD,ROLE,STATUS,SEX,BIRTHDAY,PHONE,EMAIL,ADDRESS,ACTIVECODE,UPDATETIME FROM USER WHERE ID=#{id}")
    public User findUserById(int id);

    @Select("SELECT USERNAME FROM USER WHERE USERNAME=#{username}")
    public String findUserByUsername(String username);

    @Select("SELECT NICKNAME FROM USER WHERE NICKNAME=#{nickname}")
    public String findUserByNickname(String nickname);

    @Select("SELECT ID,HEADERPIC_URL,NICKNAME,USERNAME,PASSWORD,ROLE,STATUS,SEX,BIRTHDAY,PHONE,EMAIL,ADDRESS,ACTIVECODE,UPDATETIME FROM USER WHERE USERNAME=#{username} AND PASSWORD=#{password}")
    public User findUserByUsernameAndPass(@Param("username") String username, @Param("password") String password);

    @Insert("INSERT INTO USER(HEADERPIC_URL,NICKNAME,USERNAME,PASSWORD,STATUS,SEX,BIRTHDAY,PHONE,EMAIL,ADDRESS) VALUES(#{headerpic_url},#{nickname},#{username},#{password},#{status},#{sex},#{birthday},#{phone},#{email},#{address})")
    public void addUser(User user);

    @Update("UPDATE USER SET HEADERPIC_URL=#{headerpic_url},NICKNAME=#{nickname},USERNAME=#{username},PASSWORD=#{password},STATUS=#{role},SEX=#{sex},BIRTHDAY=#{birthday},PHONE=#{phone},EMAIL=#{email},ADDRESS=#{address} WHERE ID=#{id}")
    public void updateUser(User user);

    @Update("UPDATE USER SET STATUS=#{status} WHERE ID=#{id}")
    public void updateStatus(@Param("id") int id,@Param("status") int status);

    @Update("UPDATE USER SET ROLE=#{role} WHERE ID=#{id}")
    public void updateRole(@Param("id") int id,@Param("role") String role);

    @Delete("DELETE FROM USER WHERE ID=#{id}")
    public void deleteUserById(int id);

    @Delete("DELETE FROM USER WHERE USERNAME=#{username}")
    public void deleteUserByUsername(String username);
}
