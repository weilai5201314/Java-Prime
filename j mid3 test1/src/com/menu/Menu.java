package com.menu;

import com.dao.BlogDao;
import com.dao.BlogTypeDao;
import com.dao.BlogTypeDao.*;
import com.dao.UserDao;
import com.pojo.Blog;
import com.pojo.BlogType;
import com.pojo.User;
import com.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        boolean flag = true;
        User user = new User();
        Blog blog = new Blog();
        BlogDao blogDao = new BlogDao();
        BlogTypeDao blogTypeDao = new BlogTypeDao();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("**********欢迎进入博客系统**********");
            System.out.println("**********1. 登录**********");
            System.out.println("**********2. 注册**********");
            System.out.println("**********3. 退出系统**********");
            System.out.println("请输入你要进行的操作：");
            int x = sc.nextInt();
            int userId;
            String userName;
            String passWord;
            String phone;
            switch (x) {
                case 1:
                    System.out.println("请输入你的用户名");
                    user.setUserName(sc.next());
                    System.out.println("请输入你的密码");
                    user.setPassWord(sc.next());
                    if (userDao.login(user.getUserName(),user.getPassWord()) != null)
                    {
                         Connection conn = null; // 连接对象
                        PreparedStatement ps = null; // 预编译
                         ResultSet rs = null; // 结果集
                        try {
                            conn = DBConnection.getConnection();
                            String sql = "select * from t_user where userName = ? and passWord = ?";
                            ps = conn.prepareStatement(sql);
                            ps.setString(1, user.getUserName());
                            ps.setString(2, user.getPassWord());
                            rs = ps.executeQuery();
                            if (rs.next()){
                                user=new User();
                                user.setUserId(rs.getInt("userId"));
                                user.setPhone(rs.getString("phone"));
                                user.setUserName(user.getUserName());
                                user.setPassWord(user.getPassWord());

                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        boolean flag1 = true;
                        do{
                            System.out.println("1. 创建博客");
                            System.out.println("2. 查看博客");
                            System.out.println("3. 删除博客");
                            System.out.println("4. 修改博客");
                            System.out.println("5. 返回上一级菜单");
                            System.out.println("请输入你要进行的操作：");
                            int y = sc.nextInt();
                            String blogTitle;
                            String blogContent;
                            String typeName;
                            switch (y){
                                // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
                                /********** Begin **********/
                                case 1:
                                    // 获取键盘输入的用户信息
                                    System.out.println("请输入你要创建的博客标题");
                                    blogTitle=sc.next();
                                    System.out.println("请输入你要创建的博客内容");
                                    blogContent=sc.next();
                                    System.out.println("请输入你的博客类型");
                                    typeName=sc.next();
                                    // 查询博客类型是否存在
                                    BlogType answer=blogTypeDao.findBlogType(typeName);
                                    if(answer!=null) {
                                        // 将博客信息放入博客对象中
                                        blog.setBlogTitle(blogTitle);
                                        blog.setBlogContent(blogContent);
                                        blog.setUser(user);
                                        blog.setBlogType(answer);


                                        boolean num = blogDao.addBlog(blog);
                                        if (num)
                                            // 验证博客是否创建成功
                                        {
                                            System.out.println("博客创建成功！");
                                            break;
                                        }

                                        else
                                        {
                                            System.out.println("博客创建失败");
                                            break;
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("博客类型不存在！");
                                        flag1=false;
                                    }

                                    break;
                                /********** End **********/
                                case 5:
                                    flag1 = false;
                                    break;
                                default:
                                    System.out.println("你的输入有误，请重新输入！");
                                    break;
                            }
                        }while (flag1);
                    }
                    else
                        System.out.println("用户名或密码不正确！");
                    break;
                // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
                /********** Begin **********/
                case 2:
                    // 获取键盘输入的用户信息
                    System.out.println("请输入你要注册的用户名");
                    user.setUserName(sc.next());
                    System.out.println("请输入你要注册的密码");
                    user.setPassWord(sc.next());
                    System.out.println("请输入你要注册的手机号");
                    user.setPhone(sc.next());
                    boolean answer = userDao.register(user);
                    if (answer)
                        System.out.println("注册成功！");
                    else
                        System.out.println("注册失败！");


                    // 将用户信息存入用户对象中


                    // 调用 register 方法，将用户信息传入其中，判断注册是否成功


                    break;
                case 3:
                    // 设置状态为 false，退出系统
                    System.out.println("退出系统！");
                    flag = false;
                    break;
                /********** End **********/
                default:
                    System.out.println("你的输入有误，请重新输入！");
                    break;
            }
        } while (flag);
    }
}
