public class ExamManage {

    /**
     * 功能：注册新用户
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     */
    public void register(String name, String pwd, User[] users) {
        // 判断用户名是否规范
        if (name.matches("^[^0-9][\\w_]{5,9}$")) {
            // 判断用户名是否已存在
            if (!findUser(name, users)) {
                // 判断密码是否规范
                if (pwd.matches("^[\\w_]{6,10}$")) {
                    User user = new User();
                    user.setName(name);
                    user.setPwd(pwd);
                    // 将对象放入对象数组中
                    for (int i = 0; i < users.length; i++) {
                        if (users[i] == null) {
                            users[i] = user;
                            break;
                        }
                    }
                } else {
                    System.out.println("密码不合规范！");
                }
            } else {
                System.out.println("用户名已存在！");
            }
        } else {
            System.out.println("用户名不合规范！");
        }
    }

    public boolean findUser(String name, User[] users) {
        boolean flag = false;
        // 根据用户名查找用户数组中是否已存在该用户，
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能：用户登录
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     * 返回值 boolean
     */
    public boolean login(String name, String pwd, User[] users) {
        // 查询用户名和密码是否正确
        int answ;
        answ = findUser2(name, users);
        if (answ != -1) {
            if (users[answ].getPwd().equals(pwd))
                return true;
        }
        return false;
    }

    /********** End **********/

    public int findUser2(String name, User[] users) {
        int answ = -1;
        // 根据用户名查找用户数组中是否已存在该用户，
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                answ = i;
                break;
            }
        }
        return answ;
    }

}
