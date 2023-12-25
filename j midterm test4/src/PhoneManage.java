import java.util.Objects;
import java.util.Scanner;

public class PhoneManage {
    Scanner sc = new Scanner(System.in);

    /**
     * 参数 users
     * 新增用户信息
     */
    public void addPhone(User[] users) {
        // 将键盘输入的用户信息存入用户对象中
        String name = sc.next();
        String tel = sc.next();
        User u = new User(name, tel);
        // 将对象放入对象数组中
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = u;
                break;
            }
        }
    }


    /**
     * 参数 users
     * 查询通讯录列表
     */
    public void showPhone(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null) {
                System.out.println(users[i].getName() + "\t" + users[i].getTel());
            }
        }
    }


    /**
     * 参数 users
     * 删除通讯录用户信息
     */
    public void deletePhone(User[] users) {
        // 获取键盘输入的用户名
        System.out.println("请输入姓名：");
        String delname = sc.next(); // 在控制台输入
        // 根据用户名查找该用户，最后将该用户从用户对象数组中删除
        for (int i = 0; i < users.length; i++) {
            User y = users[i]; // 把所有 users[i] 赋值给 y
            if (y != null && delname.equals(y.getName())) {
                users[i] = null;
                System.out.println("删除成功！");
                break;
            }
        }
    }

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

    /********** Begin **********/
    public void changePhone(User[] users) {
        // 获取要修改用户的名称
        sc.nextLine();

        System.out.println("请输入你要修改用户的名称：");
        String name;
        name = sc.nextLine();

        int i = 0;
        // 在用户对象数组中找到对应的用户信息
        for (i = 0; i < users.length; i++) {
            if (users[i] != null) {
                if (Objects.equals(name, users[i].getName())) {
                    // 将该用户的电话修改为键盘输入的新电话号码
//                    sc.nextLine();
                    System.out.println("请输入新电话：");
                    String telephone = sc.nextLine();
                    users[i].setTel(telephone);
                    System.out.println("修改成功！");
                }
            }
        }


    }


    /********** End **********/
}
