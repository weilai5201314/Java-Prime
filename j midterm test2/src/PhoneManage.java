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

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/

    /**
     * 参数 users
     * 查询通讯录列表
     */
    public void showPhone(User[] users) {
        User user;
        int a = 0;
        for (a = 0; a < users.length; a++) {
            if (users[a] != null) {
                user = users[a];
                System.out.printf("%s\t%s\n", user.getName(), user.getTel());
            }
        }
    }

    /********** End **********/
}
