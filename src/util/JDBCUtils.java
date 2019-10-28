/**
 * Company: ALIBABA
 * Author： ZHOUZHIQIANG
 * FileName:JDBCUtils
 * Time:2019/10/622:59
 * Description:
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class JDBCUtils {
    //获取连接
    public static Connection getConn(){
        InputStream resource = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro = new Properties();
        Connection conn=null;
        try {
            pro.load(resource);
            String driverClass = pro.getProperty("driverClass");
            String url = pro.getProperty("url");
            String username = pro.getProperty("username");
            String password = pro.getProperty("password");
            Class.forName(driverClass);
            conn=DriverManager.getConnection(url,username,password);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //获得执行对象
    public static PreparedStatement getPsmt(String sql){
        Connection conn = getConn();
        PreparedStatement psmt=null;
        if (conn != null) {
            try {
                psmt=conn.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return psmt;
    }
    //关闭更新
    public static void closeUpdate(PreparedStatement psmt){
        if (psmt!=null) {
            try {
                Connection conn = psmt.getConnection();
                psmt.close();
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //关闭查询
    public static void closeQuery(ResultSet rs){
        if (rs != null) {
            try {
                Statement psmt = rs.getStatement();
                if (psmt != null) {
                    Connection conn = psmt.getConnection();
                    rs.close();
                    psmt.close();
                    if (conn != null) {
                        conn.close();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
