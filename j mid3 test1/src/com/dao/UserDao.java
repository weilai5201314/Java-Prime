package com.dao;

import com.pojo.User;
import com.util.DBConnection;

import java.sql.*;

public class UserDao {
    static Connection conn = null; // 连接对象
    static PreparedStatement ps = null; // 预编译
    static ResultSet rs = null; // 结果集
    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能 断用户名是否存在
     * 参数 userName
     * 返回值 boolean 存在返回 true，不存在返回 flase
     */
    public boolean checkUser(String userName) {
        // 查询数据库，是否存在
        conn = DBConnection.getConnection();
        if (conn != null) {
            String sql = "SELECT * FROM t_user WHERE userName = ?";
            try {
                ps = conn.prepareStatement(sql);
                ps.setString(1, userName);
                rs = ps.executeQuery();
                if (rs.next())
                    return true;
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    /**
     * 参数 user
     * 返回值 boolean 注册返回 true，失败返回 flase
     */
    public boolean register(User user) {
        //  注册之前先检查用户是否存在
        //  不存在，开始写入数据库
        if (!checkUser(user.getUserName())) {

            conn = DBConnection.getConnection();
            if (conn != null) {
                String sql = "insert into t_user(userName,passWord,phone) values(?,?,?)";
                try {
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassWord());
                    ps.setString(3, user.getPhone());
                    int ok = ps.executeUpdate();
                    return ok == 1;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return true;
        } else {
            System.out.println("用户名已存在");
            return false;

        }
    }

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能 用户登录验证
     * 参数 user
     * 返回值 User 对象
     */

    public User login(String userName, String passWord) {
        boolean result = false;
        User user = null;
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from t_user where userName = ? and passWord = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            rs = ps.executeQuery();
            if (rs.next()){
                user=new User();
                user.setUserId(rs.getInt("userId"));
                user.setPhone(rs.getString("phone"));
                user.setUserName(userName);
                user.setPassWord(passWord);
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    /********** End **********/
}