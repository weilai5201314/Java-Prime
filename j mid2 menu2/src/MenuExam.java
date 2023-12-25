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
            String str = sc.next();
            // 实现注册功能
            if ("1".equals(str)) {
                // 获取键盘输入的用户名
                System.out.println("请输入你要注册的用户名：");
                String name = sc.next();
                // 获取键盘输入的密码
                System.out.println("请输入你要注册的密码：");
                String pwd = sc.next();
                // 将参数传入 register 方法中
                examManage.register(name, pwd, users);

                // 请在下面的Begin-End之间编写正确的代码
                /********** Begin **********/
            } else if ("2".equals(str)) {
                System.out.println("请输入你的用户名：");
                String name = sc.next();

                System.out.println("请输入你的密码：");
                String pwd = sc.next();

                boolean answ = examManage.login(name, pwd, users);
                if (answ) {
                    System.out.println("选择考试科目\n" +
                            "**********\n" +
                            "1. 英语\n" +
                            "2. 数学\n" +
                            "3. 返回上一级菜单\n" +
                            "4. 退出系统\n" +
                            "5. 查询考试成绩\n" +
                            "**********");
                    return;
                } else
                    System.out.println("用户名或密码错误，登录失败！");
                /********** End **********/


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

