package com.dao;

import com.pojo.BlogType;

import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogTypeDao {
    static Connection conn = null; // 连接对象
    static PreparedStatement ps = null; // 预编译
    static ResultSet rs = null; // 结果集

    /**
     * 功能 查找博客类型是否存在
     * 参数 blogType
     * 返回值 博客类型对象
     */
    public BlogType findBlogType(String typeName) {

        BlogType blogType = new BlogType();
        // 判断博客类型是否存在
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from blog_type where typeName = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, typeName);
            rs = ps.executeQuery();
            // 如果存在，返回该博客类型对象信息
            if (rs.next()){
                blogType.setTypeId(rs.getInt("typeId"));
                blogType.setTypeName(rs.getString("typeName"));
                return blogType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 不存在则返回 null
        return null;
    }

}
