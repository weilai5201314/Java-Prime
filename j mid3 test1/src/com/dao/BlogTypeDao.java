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
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********** Begin **********/

        // 判断博客类型是否存在
        conn=DBConnection.getConnection();
        if(conn!=null)
        {
            String sql="SELECT * FROM blog_type WHERE typeName=?";
            try {
                ps=conn.prepareStatement(sql);
                ps.setString(1,typeName);
                rs=ps.executeQuery();
                if(rs.next())
                {
                    // 如果存在，返回该博客类型对象信息
                    BlogType blogType=new BlogType();
                    blogType.setTypeId(rs.getInt("typeId"));
                    blogType.setTypeName(rs.getString("typeName"));
                    return blogType;
                }
                // 不存在则返回 null
                else
                    return null;

            }catch (SQLException e) {
                e.printStackTrace();
            }
        }




        return null;

        /********** End **********/
    }

}
