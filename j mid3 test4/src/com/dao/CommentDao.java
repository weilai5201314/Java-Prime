package com.dao;

import com.pojo.Comment;
import com.pojo.User;
import com.util.DBConnection;

import java.sql.*;

public class CommentDao {
    static Connection conn = null; // 连接对象
    static PreparedStatement ps = null; // 预编译
    static ResultSet rs = null; // 结果集


    /**
     * 功能 添加评论
     * 参数 comment
     */
    public void addComment(Comment comment) {
        try {
            conn = DBConnection.getConnection();
            String sql = "insert into t_comment (commentContent,blogId,createTime,userId) values (?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, comment.getCommentContent());
            ps.setInt(2, comment.getBlog().getBlogId());
            ps.setTimestamp(3, new Timestamp(comment.getDate().getTime()));
            ps.setInt(4, comment.getUser().getUserId());
            int i = ps.executeUpdate();
            // 判断是否添加成功
            if (i == 1) {
                System.out.println("评论发布成功！");
            } else {
                System.out.println("评论发布失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能 查询自己发步的评论
     *
     * @param user
     */
    public void findMyComments(User user) {
        // 通过三表关联查询，查询自己发步的评论
        try {
            conn = DBConnection.getConnection();
            String sql = "select t_blog.blogId blogId,t_blog.blogTitle blogTitle,t_blog.blogContent blogContent,comment.commentContent from (select * from t_comment where userId = ?)comment left join t_blog on comment.blogId = t_blog.blogId";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("我发布的评论如下：");
            System.out.println("blogId\tblogTitle\tblogContent\tcommentContent");
            while (rs.next()) {
                int blogId = rs.getInt("blogId");
                String blogTitle = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String commentContent = rs.getString("commentContent");
                System.out.println(blogId + "\t" + blogTitle + "\t" + blogContent + "\t" + commentContent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 功能 查询博客的所有评论
     * 参数 blogId
     */
    public void findCommentById(int blogId) {
        // 根据 ID 查询博客的所有评论
        try {
            conn = DBConnection.getConnection();
            String sql = "select t.blogId blogId,t.blogTitle blogTitle,t.blogContent blogContent,t.commentContent,t_user.userName from (select t_blog.blogId blogId,t_blog.blogTitle blogTitle,t_blog.blogContent blogContent,comment.commentContent,comment.userId userId from (select * from t_comment where blogId = ?)comment left join t_blog on comment.blogId = t_blog.blogId)t left join t_user on t.userId = t_user.userId\n";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, blogId);
            rs = ps.executeQuery();
            // 输出查询结果
            System.out.println("博客的评论如下：");
            System.out.println("blogId\tblogTitle\tblogContent\tcommentContent\tuserName");
            while (rs.next()) {
                String blogTitle = rs.getString("blogTitle");
                String blogContent = rs.getString("blogContent");
                String commentContent = rs.getString("commentContent");
                String userName = rs.getString("userName");
                System.out.println(blogId + "\t" + blogTitle + "\t" + blogContent + "\t" + commentContent + "\t" + userName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能 删除评论
     *
     * @param commentId
     * @param userId
     * @param createUserId
     */
    public void deleteComment(int commentId, int userId, int createUserId) {
        try {
            // 删除评论
            conn = DBConnection.getConnection();
//            String sql = "delete from t_comment where commentId=? and (userId=? or userId=?)";
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, commentId);
//            ps.setInt(2, userId);
//            ps.setInt(3, createUserId);
            String sql = "delete from t_comment  where commentId= ? and (userId = ? or ? = ?);";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, commentId);
            ps.setInt(2, userId);
            ps.setInt(3, createUserId);
            ps.setInt(4, userId);  // 多余的占位符，与 userId 关联两次

            // 判断是否删除成功
            System.out.println("Executing SQL: " + ps.toString());

            int ok = ps.executeUpdate();
            if (ok == 1)
                System.out.println("评论删除成功！");
            else
                System.out.println("评论删除失败！");

        } catch (Exception e) {
            e.printStackTrace();
        }


        /********** End **********/
    }
}