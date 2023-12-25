import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// 此类为整个通讯录的总控制，负责启动
public class MenuExam {

    public static void main(String[] args) {

        User[] users = new User[50]; // 创建一个对象数组，用于存放所有的用户信息
        // 实例化 Scanner 对象
        Scanner sc = new Scanner(System.in);
        // 实例化 ExamManage 对象
        ExamManage examManage = new ExamManage();
        while (true) {
            System.out.println("线上考试系统");
            System.out.println("**********");
            System.out.println("1. 新用户注册");
            System.out.println("2. 用户登录");
            System.out.println("3. 退出系统");
            System.out.println("**********");
            System.out.println("请输入选择的操作：");
            // 获取键盘输入
            String str = sc.nextLine();
            // 实现注册功能
            if ("1".equals(str)) {
                // 获取键盘输入的用户名
                System.out.println("请输入你要注册的用户名：");
                String name = sc.nextLine();
                // 获取键盘输入的密码
                System.out.println("请输入你要注册的密码：");
                String pwd = sc.nextLine();
                // 将参数传入 register 方法中
                examManage.register(name, pwd, users);

            } else if ("2".equals(str)) {
                System.out.println("请输入你的用户名：");
                String name = sc.nextLine();
                System.out.println("请输入你的密码：");
                String pwd = sc.nextLine();
                boolean flag = examManage.login(name, pwd, users);
                if (flag) {

                    while (true) {
                        System.out.println("选择考试科目");
                        System.out.println("**********");
                        System.out.println("1. 英语");
                        System.out.println("2. 数学");
                        System.out.println("3. 返回上一级菜单");
                        System.out.println("4. 退出系统");
                        System.out.println("5. 查询考试成绩");
                        System.out.println("**********");
                        System.out.println("请输入选择的操作：");
                        // 获取键盘输入
                        String s = sc.nextLine();
                        if ("1".equals(s)) {
                            System.out.println("欢迎参加英语考试，开始答卷");
                            // 读取文件内容并打印出来
//                            try {
//                                BufferedReader in = new BufferedReader(new FileReader("/root/english.txt"));
//                                String text;
//                                while ((text = in.readLine()) != null) {
//                                    System.out.println(text);
//                                }
//                                System.out.println("请输入答案，答案之间用英文逗号分开");
//                                // 获取键盘输入的答案，并将其转化为大写字母
//                                String answers = sc.nextLine().toUpperCase();
//                                examManage.engExam(answers, name, pwd, users);
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }

                        } else if ("2".equals(s)) {

                            System.out.println("欢迎参加数学考试，开始答卷");
                            // 读取文件内容并打印出来
//                            try {
//                                BufferedReader in = new BufferedReader(new FileReader("/root/math.txt"));
//                                String text;
//                                while ((text = in.readLine()) != null) {
//                                    System.out.println(text);
//                                }
//                                System.out.println("请输入答案，答案之间用英文逗号分开");
//                                // 获取键盘输入的答案，并将其转化为大写字母
//                                String answers = sc.nextLine().toUpperCase();
//                                examManage.mathExam(answers, name, pwd, users);
//
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
                        } else if ("3".equals(s)) {
                            break;
                        } else if ("4".equals(s)) {
                            System.exit(0);
                        } else if ("5".equals(s)) {
                            // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
                            /********** Begin **********/
                            // 调用 show 方法，实现查询用户的功能
                            examManage.show(name, pwd, users);

                            /********** End **********/
                        }
                    }
                } else {
                    System.out.println("用户名或密码错误，登录失败！");
                }
            } else if ("3".equals(str)) {
                // 退出操作
                System.out.println("退出成功！");
                break;
            } else {
                System.out.println("选择错误！");
            }
        }
    }
}

