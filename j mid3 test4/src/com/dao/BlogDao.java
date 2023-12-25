package com.dao;

import com.pojo.Blog;
import com.pojo.BlogType;
import com.pojo.User;
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
        boolean result = false;
        // 插入博客数据到博客表中
        try {
            conn = DBConnection.getConnection();
            String sql = "insert into t_blog (blogTitle,blogContent,userId,typeId) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, blog.getBlogTitle());
            ps.setString(2, blog.getBlogContent());
            ps.setInt(3, blog.getUser().getUserId());
            ps.setInt(4, blog.getBlogType().getTypeId());
            int i = ps.executeUpdate();
            // 判断是否添加成功
            if (i == 1) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 功能：查询所有博客
     */
    public void findAllBlogs() {
        // 通过三表关联查询，查询所有的博客
        try {
            conn = DBConnection.getConnection();
            String sql = "select t.blogId blogId,t.blogTitle blogTitle,t.blogContent blogContent,t.typeName,t_user.userName userName from(select t_blog.*,blog_type.typeName from t_blog left join blog_type on t_blog.typeId = blog_type.typeId) t left join t_user on t.userId = t_user.userId;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("blogId\tblogTitle\tblogContent\ttypeName\tuserName");
            while (rs.next()){
                int blogId = rs.getInt("blogId");
                String blogTitle = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String typeName = rs.getString("typeName");
                String userName = rs.getString("userName");
                System.out.println(blogId+"\t"+blogTitle+"\t"+blogContent+"\t"+typeName+"\t"+userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能 查询自己创建的博客
     * 参数 user
     */
    public void findMyBlogs(User user) {
        // 通过三表关联查询，查询自己创建的博客
        try {
            conn = DBConnection.getConnection();
            String sql = "select blog.*,blog_type.typeName from (select * from t_blog where userId = ?)blog left join blog_type on blog.typeId = blog_type.typeId";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getUserId());
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("我创建的博客如下：");
            System.out.println("blogId\tblogTitle\tblogContent\ttypeName");
            while (rs.next()){
                int blogId = rs.getInt("blogId");
                String blogTitle = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String typeName = rs.getString("typeName");
                System.out.println(blogId+"\t"+blogTitle+"\t"+blogContent+"\t"+typeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/

    /**
     * 功能 根据指定博客 ID 删除自己所创建的博客，如果有评论，也需全部删除
     * 参数 blogId
     * 参数 user
     */
    public void deleteBlog(int blogId, User user) {

        try {
            String sql;
            // 查询是否可以被该用户删除
            conn = DBConnection.getConnection();
            sql = "select * from t_blog where userId = ? and blogId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.setInt(2, blogId);
            rs = ps.executeQuery();
            if (rs.next()){
                // 如果可以，删除该博客的所有评论
                sql = "delete from t_comment where blogId = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, blogId);
                ps.executeUpdate();
                // 再删除该博客
                sql = "delete from t_blog where blogId = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1,blogId);
                ps.executeUpdate();
                System.out.println("博客删除成功！");
                // 否者，输出博客删除失败！
            }else{
                System.out.println("博客删除失败！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /********** End **********/




    /**
     * 功能 根据博客 ID 修改自己创建的博客
     * 参数 blog
     */
    public void updateBlog(Blog blog) {
        try {
            conn = DBConnection.getConnection();
            String sql = "update t_blog set blogTitle = ?,blogContent = ?,typeId = ? where userId = ? and blogId = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,blog.getBlogTitle());
            ps.setString(2,blog.getBlogContent());
            ps.setInt(3, blog.getBlogType().getTypeId());
            ps.setInt(4, blog.getUser().getUserId());
            ps.setInt(5, blog.getBlogId());
            int i = ps.executeUpdate();
            // 判断是否删除成功
            if (i == 1) {
                System.out.println("博客修改成功！");
            }else {
                System.out.println("博客修改失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能 根据博客 ID 查询指定博客
     * 参数 blogId
     */
    public void findBlogById(int blogId) {
        // 根据博客 ID 查询指定博客
        try {
            conn = DBConnection.getConnection();
            String sql = "select t.blogTitle blogTitle,t.blogContent blogContent,t.typeName,t_user.userName userName from(select blog.*,blog_type.typeName from (select * from t_blog where blogId = ?)blog left join blog_type on blog.typeId = blog_type.typeId) t left join t_user on t.userId = t_user.userId;";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogId);
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("blogId\tblogTitle\tblogContent\ttypeName\tuserName");
            while (rs.next()){
                String blogTitle = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String typeName = rs.getString("typeName");
                String userName = rs.getString("userName");
                System.out.println(blogId+"\t"+blogTitle+"\t"+blogContent+"\t"+typeName+"\t"+userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 功能 根据博客标题模糊查询博客
     * 参数 blogTitle
     */
    public void findBlogByTitle(String blogTitle) {
        // 根据博客标题模糊查询博客
        try {
            conn = DBConnection.getConnection();
            String sql = "select t.blogId blogId,t.blogTitle blogTitle,t.blogContent blogContent,t.typeName,t_user.userName userName from(select blog.*,blog_type.typeName from (select * from t_blog where blogTitle like ?)blog left join blog_type on blog.typeId = blog_type.typeId) t left join t_user on t.userId = t_user.userId;";
            ps = conn.prepareStatement(sql);
            ps.setString(1,"%"+blogTitle+"%");
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("blogId\tblogTitle\tblogContent\ttypeName\tuserName");
            while (rs.next()){
                int blogId = rs.getInt("blogId");
                String b = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String typeName = rs.getString("typeName");
                String userName = rs.getString("userName");
                System.out.println(blogId+"\t"+b+"\t"+blogContent+"\t"+typeName+"\t"+userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public boolean checkBlogById(int blogId) {
        boolean result = false;
        // 根据博客 ID 查询指定博客
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from t_blog where blogId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogId);
            rs = ps.executeQuery();
            // 输出查询结果
            if (rs.next()){
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }



    /**
     * 功能 根据博客 ID 查询创建者 ID
     * 参数 blogId
     * 返回值 创建者 ID
     */
    public int findUserById(int blogId) {
        // 根据博客 ID 查询创建者 ID
        try {
            conn = DBConnection.getConnection();
            String sql = "select * from t_blog where blogId = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,blogId);
            rs = ps.executeQuery();
            // 输出查询结果
            if (rs.next()){
                return rs.getInt("userId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
