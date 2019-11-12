package cn.programminglife.bean;

import java.sql.Timestamp;

/**
 * @author programmerlc
 * @create 2019-10-10-15:55
 */
public class User {
    //主键id
    private int id;
    //头像图片路径
    private String headerpic_url;
    //昵称
    private String nickname;
    //用户名
    private String username;
    //密码
    private String password;
    //角色
    private String role;
    //状态
    private int status;
    //性别
    private String sex;
    //生日
    private String birthday;
    //手机号
    private String phone;
    //邮箱
    private String email;
    //地址
    private String address;
    //激活码
    private String activecode;
    //更新时间
    private Timestamp updatetime;

    public User(int id, String headerpic_url, String nickname, String username, String password, String role, int status, String sex, String birthday, String phone, String email, String address, String activecode, Timestamp updatetime) {
        this.id = id;
        this.headerpic_url = headerpic_url;
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
        this.sex = sex;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.activecode = activecode;
        this.updatetime = updatetime;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeaderpic_url() {
        return headerpic_url;
    }

    public void setHeaderpic_url(String headerpic_url) {
        this.headerpic_url = headerpic_url;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getActivecode() {
        return activecode;
    }

    public void setActivecode(String activecode) {
        this.activecode = activecode;
    }

    public Timestamp getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Timestamp updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", headerpic_url='" + headerpic_url + '\'' +
                ", nickname='" + nickname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", activecode='" + activecode + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }
}
