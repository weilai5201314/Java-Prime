//package step1;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class UpdatePass {
//    // 修改数据
//    public static void updateDB() {
//        Connection con = null;   // 数据库连接对象con
//        Statement stat = null;    // 语句对象stat
//
//        try {
//            /********* Begin *********/
//            // 第一步：加载驱动
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // 第二步：建立连接, "root"和"123123"是针对MySQL设置了用户名(root)和密码(123123)的情况
//            // 127.0.0.1:3306是mysql服务器地址及端口   数据库编码格式设置为utf-8
//            String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/tsgc?useUnicode=true&characterEncoding=UTF-8";
//            String username = "root";
//            String password = "123123";
//            con = DriverManager.getConnection(jdbcUrl, username, password);
//            /********* End *********/
//
//            // 第三步：建立statement对象
//            stat = con.createStatement();
//            // 第四步：修改数据
//            String sql = "UPDATE employee SET password='hello' where sex = '女'";
//            stat.executeUpdate(sql);
//
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        } finally {
//            // 在这里关闭连接
//            try {
//                if (stat != null) {
//                    stat.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
package step1;

import java.sql.*;

public class UpdatePass {
    // 修改数据
    public static void updateDB() {

        /********* Begin *********/

        // 第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }

        // 第二步：建立连接, "root"和"123123"是针对MySQL设置了用户名(root)和密码(123123)的情况
        // 127.0.0.1:3306是mysql服务器地址及端口 数据库编码格式设置为utf-8
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/tsgc?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String password = "123123";
            conn = DriverManager.getConnection(url, user, password);
            // 第三步：建立statement对象
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM employee";
            ResultSet  rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                int no = rs.getInt("no");
                String name = rs.getString("name");
                int pass=rs.getInt("password");
                String sex = rs.getString("sex");
                float salary=rs.getFloat("salary");
                if(name!=null &&sex!=null)
                {
                   System.out.printf("no:%d\tname:%s\tpassword:%d\tsex:%s\tsalary:%.1f\n",no,name,pass,sex,salary);
                }
            }
            // 第五步：关闭statement对象和连接对象
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                // TODO 自动生成的 catch 块
                e.printStackTrace();
            }

        }

        /********* End *********/

    }

}
