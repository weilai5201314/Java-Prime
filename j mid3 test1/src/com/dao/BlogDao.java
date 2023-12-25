package com.dao;

import com.pojo.Blog;
import com.pojo.BlogType;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BlogDao {
    static Connection conn = null; // 连接对象
    static PreparedStatement ps = null; // 预编译
    static ResultSet rs = null; // 结果集

    public boolean addBlog(Blog blog) {
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********** Begin **********/

        // 插入博客数据到博客表中
        conn=DBConnection.getConnection();
        // 判断是否添加成功
        if(conn!=null)
        {
            String sql="insert into t_blog(blogTitle, blogContent, userId, typeId) values(?,?,?,?)";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,blog.getBlogTitle());
                ps.setString(2,blog.getBlogContent());
                ps.setInt(3, blog.getUser().getUserId());
                ps.setInt(4, blog.getBlogType().getTypeId());
                int ok=ps.executeUpdate();
                return ok==1;

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    /********** End **********/
}
