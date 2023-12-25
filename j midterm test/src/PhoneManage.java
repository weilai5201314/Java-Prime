import java.util.Scanner;

public class PhoneManage {
    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    // 实例化 Scanner 对象
    Scanner sc = new Scanner(System.in);
    String name, telephone;

    /**
     * addPhone
     * 参数 users
     * 新增用户信息
     */

    // 将键盘输入的用户信息存入用户对象中
    public void addPhone(User[] users) {
        System.out.println("请输入姓名：");
        name = sc.next();
        System.out.println("请输入手机号：");
        telephone = sc.next();

        User user = new User(name, telephone);
        users[0] = user;
    }

    // 将对象放入对象数组中


    /********** End **********/
}
