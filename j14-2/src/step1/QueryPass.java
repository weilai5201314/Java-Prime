package step1;

import java.sql.*;

public class QueryPass {


    public static void queryDB() {
        Connection con=null;      //数据库连接对象con
        Statement stat=null;      //语句对象 stat
        ResultSet rs = null;      //结果集 rs


        /********* Begin *********/

        // 第一步：加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            // TODO 自动生成的 catch 块
            e1.printStackTrace();
        }


        // 第二步：建立连接, "root"和"123123"是针对MySQL设置了用户名(root)和密码(123123)的情况
        // 127.0.0.1:3306是mysql服务器地址及端口   数据库编码格式设置为utf-8
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/tsgc?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String password = "123123";
            conn = DriverManager.getConnection(url, user, password);
            // 第三步：建立statement对象

            String sql = "update employee set password='hello' where sex='女'";
            ps = conn.prepareStatement(sql);

            // 第四步：修改数据
            ps.execute();
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
