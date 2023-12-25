import java.util.Objects;

public class ExamManage {

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能：注册新用户
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     */
    public void register(String name, String pwd, User[] users) {
        // 判断用户名是否规范
        String regex = "[a-zA-Z_]{1}[a-zA-Z0-9_]{5,9}";
        if (!name.matches(regex)) {
            System.out.println("用户名不合规范！");
            return;
        }
        // 判断用户名是否已存在
        for (User user : users) {
            // 存在，打印并退出
//            if (user == null)
//                break;
//            if (Objects.equals(user.getName(), name)) {
//                System.out.println("用户名已存在！");
//                return;
            if (user != null && Objects.equals(user.getName(), name)) {
                System.out.println("用户名已存在！");
                return;
            }
        }
        // 判断密码是否规范
        regex = "[a-zA-Z0-9_]{6,10}";
        if (!pwd.matches(regex)) {
            System.out.println("密码不合规范！");
            return;
        }
        // 将对象放入对象数组中
        for (int i = 1; i < users.length; i++) {
            // 如果为空，开始存储
            if (users[i] == null) {
                User u = new User(name, pwd);

                users[i] = u;
                // 存储完了break
                return;
            }

        }
    }

    /********** End **********/

}
