/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:UserDaoImple
 * Time:2019/10/817:18
 * Description:
 */
package dao.daoImple;

import dao.UserDao;
import model.User;
import util.JDBCUtils;

import java.lang.ref.PhantomReference;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImple implements UserDao {
    @Override
    public void addUser(User user) {
        String sql="INSERT INTO cs_user (username,PASSWORD,gender,birthday,address,sal,pic) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement psmt=null;
        try {
            psmt=JDBCUtils.getPsmt(sql);
            psmt.setString(1,user.getUsername());
            psmt.setString(2,user.getPassword());
            psmt.setInt(3,user.getGender());
            psmt.setDate(4,new Date(user.getBirthday().getTime()));
            psmt.setString(5,user.getAddress());
            psmt.setBigDecimal(6,user.getSal());
            psmt.setString(7,user.getPic());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeUpdate(psmt);
        }
    }

    @Override
    public void delUser(Integer user_id) {
        String sql="DELETE FROM cs_user WHERE user_id=?";
        PreparedStatement psmt=null;
        psmt=JDBCUtils.getPsmt(sql);
        try {
            psmt.setInt(1,user_id);
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeUpdate(psmt);
        }
    }

    @Override
    public void updateUser(User user) {
        String sql="UPDATE cs_user SET username=?,PASSWORD=?,gender=?,birthday=?,address=?,sal=?,pic=? WHERE user_id=?";
        PreparedStatement psmt=null;
        psmt=JDBCUtils.getPsmt(sql);
        try {
            psmt.setString(1,user.getUsername());
            psmt.setString(2,user.getPassword());
            psmt.setInt(3,user.getGender());
            psmt.setDate(4,new Date(user.getBirthday().getTime()));
            psmt.setString(5,user.getAddress());
            psmt.setBigDecimal(6,user.getSal());
            psmt.setString(7,user.getPic());
            psmt.setInt(8,user.getUser_id());
            psmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeUpdate(psmt);
        }
    }

    @Override
    public User getUser(Integer user_id) {
        PreparedStatement pstmt = null;
        String sql = "select * from cs_user where user_id = ?";
        ResultSet rs = null;
        User user=new User();
        try{
            pstmt =JDBCUtils.getPsmt(sql);
            pstmt.setInt(1,user_id);
            rs = pstmt.executeQuery();
            rs.next();
            String username = rs.getString("username");
            String password = rs.getString("password");
            Integer gender = rs.getInt("gender");
            java.util.Date birthday = rs.getDate("birthday");
            String address = rs.getString("address");
            BigDecimal sal = rs.getBigDecimal("sal");
            String pic = rs.getString("pic");

            user.setUser_id(user_id);
            user.setUsername(username);
            user.setPassword(password);
            user.setBirthday(birthday);
            user.setAddress(address);
            user.setGender(gender);
            user.setSal(sal);
            user.setPic(pic);
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
           JDBCUtils.closeQuery(rs);
        }
        return user;
    }

    @Override
    public List<User> uList() {
        String sql="SELECT *FROM cs_user";
        PreparedStatement psmt = JDBCUtils.getPsmt(sql);
        ResultSet rs=null;
        List<User> uList=new ArrayList<>();
        try {
            rs=psmt.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                int gender = rs.getInt("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                BigDecimal sal = rs.getBigDecimal("sal");
                String pic = rs.getString("pic");
                User user = new User();
                user.setUser_id(user_id);
                user.setUsername(username);
                user.setPassword(password);
                user.setGender(gender);
                user.setBirthday(birthday);
                user.setAddress(address);
                user.setSal(sal);
                user.setPic(pic);
                uList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeQuery(rs);
        }
        return uList;
    }

    @Override
    public User getUserByNameAndPassword(String username, String password) {
        String sql="SELECT * from cs_user WHERE username=? ANd password=?";
        PreparedStatement psmt = JDBCUtils.getPsmt(sql);
        ResultSet rs=null;
        User user=null;
        try {
            psmt.setString(1,username);
            psmt.setString(2,password);
            rs= psmt.executeQuery();
            if (rs.next()) {
                int user_id = rs.getInt("user_id");
                int gender = rs.getInt("gender");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                BigDecimal sal = rs.getBigDecimal("sal");
                String pic = rs.getString("pic");
                user=new User();
                user.setUser_id(user_id);
                user.setUsername(username);
                user.setSal(sal);
                user.setBirthday(birthday);
                user.setGender(gender);
                user.setAddress(address);
                user.setPic(pic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.closeQuery(rs);
        }
        return  user;
    }
}
