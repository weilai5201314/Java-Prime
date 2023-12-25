package com.dao;

import com.pojo.User;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    static Connection conn = null; // 连接对象
    static PreparedStatement ps = null; // 预编译
    static ResultSet rs = null; // 结果集

    /**
     * 功能 断用户名是否存在
     * 参数 userName
     * 返回值 boolean 存在返回 true，不存在返回 flase
     */
    public boolean checkUser(String userName) {
        boolean result = false;
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from t_user where userName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("用户名已存在");
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 功能 注册用户
     * 参数 user
     * 返回值 boolean 注册返回 true，失败返回 flase
     */
    public boolean register(User user) {
        boolean result = false;
        boolean b = checkUser(user.getUserName());
        if (!b) {
            try {
                conn = DBConnection.getConnection();
                String sql = "insert into t_user (userName,passWord,phone) values (?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getPassWord());
                ps.setString(3, user.getPhone());
                int i = ps.executeUpdate();
                if (i == 1) {
                    result = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 功能 用户登录验证
     * 参数 user
     * 返回值 User 对象
     */

    public User login(String userName, String passWord) {
        boolean result = false;
        User user = new User();
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from t_user where userName = ? and passWord = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            rs = ps.executeQuery();
            if (rs.next()) {
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

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/

    /**
     * 功能 注销自己的账号
     * 参数 user
     */
    public void deleteUser(User user) {


        try {
            conn = DBConnection.getConnection();

            // 首先我们需要删除该用户发布的评论；
            String sql = "delete from t_comment where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();

            // 再删除该用户创建的博客中所有的评论；
            sql = "select blogId from t_blog where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            while (rs.next()) {
                // 删除每一个blogId的评论
                sql = "delete from t_comment where blogId=?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("blogId"));
                ps.executeUpdate();


            }

            // 然后我们需要删除该用户所创建的博客
            sql = "delete from t_blog where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();

            //  最后再从数据库中删除自己的信息
            sql = "delete from t_user where userId=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void deleteUser2(User user) {
        try {
            conn = DBConnection.getConnection();

            // 1. 删除用户发布的评论
            String deleteCommentsSql = "DELETE FROM t_comment WHERE userId=?";
            ps = conn.prepareStatement(deleteCommentsSql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();

            // 2. 查询用户创建的博客
            String selectBlogsSql = "SELECT blogId FROM t_blog WHERE userId=?";
            ps = conn.prepareStatement(selectBlogsSql);
            ps.setInt(1, user.getUserId());
            rs = ps.executeQuery();

            // 3. 删除每个博客及其相关评论
            while (rs.next()) {
                deleteBlog(rs.getInt("blogId"));
            }

            // 4. 删除用户创建的博客
            String deleteBlogsSql = "DELETE FROM t_blog WHERE userId=?";
            ps = conn.prepareStatement(deleteBlogsSql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();

            // 5. 最后删除用户信息
            String deleteUserSql = "DELETE FROM t_user WHERE userId=?";
            ps = conn.prepareStatement(deleteUserSql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBlog(int blogId) {
        try {
            // 删除博客的评论
            String deleteCommentsSql = "DELETE FROM t_comment WHERE blogId=?";
            ps = conn.prepareStatement(deleteCommentsSql);
            ps.setInt(1, blogId);
            ps.executeUpdate();

            // 删除博客
            String deleteBlogSql = "DELETE FROM t_blog WHERE blogId=?";
            ps = conn.prepareStatement(deleteBlogSql);
            ps.setInt(1, blogId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /********** End **********/
}