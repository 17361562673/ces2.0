/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:User
 * Time:2019/10/623:20
 * Description:
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private Integer gender;
    private Date birthday;
    private String address;
    private BigDecimal sal;
    private String pic;
    public Integer getUser_id() {
        return user_id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getSal() {
        return sal;
    }

    public void setSal(BigDecimal sal) {
        this.sal = sal;
    }
}
