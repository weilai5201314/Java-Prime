//
//import java.util.Scanner;
//
//// 此类为整个通讯录的总控制，负责启动
//public class MenuExam {
//
//    public static void main(String[] args) {
//
//        User[] users = new User[50]; // 创建一个对象数组，用于存放所有的用户信息
//        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
//        /********** Begin **********/
//        // 实例化 Scanner 对象
//        Scanner sc = new Scanner(System.in);
//        // 实例化 ExamManage 对象
//        ExamManage em = new ExamManage();
//
//        while (true)
//        {
//            System.out.println("线上考试系统");
//            System.out.println("**********");
//            System.out.println("1. 新用户注册");
//            System.out.println("2. 用户登录");
//            System.out.println("3. 退出系统");
//            System.out.println("**********");
//            System.out.println("请输入选择的操作：");
//            // 获取键盘输入
//            int command;
//            String name, password;
//            command = sc.nextInt();
//            sc.nextLine();
//            switch (command) {
//                case 1:
//                    // 开始注册
//                    // 实现注册功能
//                    // 获取键盘输入的用户名
//                    System.out.println("请输入你要注册的用户名：");
//                    name = sc.nextLine();
//                    // 获取键盘输入的密码
//                    System.out.println("请输入你要注册的密码：");
//                    password = sc.nextLine();
//                    // 将参数传入 register 方法中
//                    em.register(name, password, users);
//                    break;
//                case 3:
//                    System.out.println("退出成功！");
//                   break;
//                default:
//                    System.out.println("选择错误！");
//
//            }
//
//
//            // 退出操作
//
//
//            /********** End **********/
//        }
//
//    }
//}
//

import java.util.Scanner;

// 此类为整个通讯录的总控制，负责启动
public class MenuExam {

    public static void main(String[] args) {

        User[] users = new User[50]; // 创建一个对象数组，用于存放所有的用户信息
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********** Begin **********/
        // 实例化 Scanner 对象
        Scanner sc = new Scanner(System.in);
        // 实例化 ExamManage 对象
        ExamManage em = new ExamManage();

        while (true) {
            System.out.println("线上考试系统");
            System.out.println("**********");
            System.out.println("1. 新用户注册");
            System.out.println("2. 用户登录");
            System.out.println("3. 退出系统");
            System.out.println("**********");
            System.out.println("请输入选择的操作：");
            // 获取键盘输入
            String command;
            String name, password;
            command = sc.nextLine();


            switch (command) {
                case "1":
                    // 开始注册
                    // 实现注册功能
                    // 获取键盘输入的用户名
                    System.out.println("请输入你要注册的用户名：");
                    name = sc.nextLine();
                    // 获取键盘输入的密码
                    System.out.println("请输入你要注册的密码：");
                    password = sc.nextLine();
                    // 将参数传入 register 方法中
                    em.register(name, password, users);
                    break;
                case "3":
                    System.out.println("退出成功！");
                    return;
                default:
                    System.out.println("选择错误！");

            }


            // 退出操作


            /********** End **********/
        }


    }
}

