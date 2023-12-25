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

    /**
     * 功能：用户登录
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     * 返回值 boolean
     */
    public boolean login(String name, String pwd, User[] users) {
        // 查询用户名和密码是否正确
        boolean flag = false;

        for (User user : users) {
            if (user != null && name.equals(user.getName()) && pwd.equals(user.getPwd())) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 功能：模拟英语考试，计算得分
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     * 参数 answers 用户试卷答案
     */
    public void engExam(String answers, String name, String pwd, User[] users) {
        // 切分用户的答案
        double score = 0.0;
        String[] split = answers.split(",");
        // 对比正确答案，计算用户分数
        if ("A".equals(split[0]) || "a".equals(split[0])) {
            score += 5;
        }
        if ("C".equals(split[1]) || "c".equals(split[1])) {
            score += 5;
        }
        // 最后所得分数为该用户的英语成绩
        for (User z : users) {
            if (z != null && name.equals(z.getName()) && pwd.equals(z.getPwd())) {
                z.setEnglish(score);
                break;
            }
        }
    }


    /**
     * 功能：模拟数学考试，计算得分
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     * 参数 answers 用户试卷答案
     */
    public void mathExam(String answers, String name, String pwd, User[] users) {
        // 切分用户的答案
        double score = 0.0;
        String[] split = answers.split(",");
        // 对比正确答案，计算用户分数
        if ("C".equals(split[0]) ) {
            score += 5;
        }
        if ("A".equals(split[1]) ) {
            score += 5;
        }
        score=0.0;
        // 最后所得分数为该用户的英语成绩
        for (User z : users) {
            if (z != null && name.equals(z.getName()) && pwd.equals(z.getPwd())) {
                z.setMath(score);
                break;
            }
        }
    }
    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/
    /**
     * 功能：查询用户成绩
     * 参数 name 用户名
     * 参数 pwd 密码
     * 参数 users 用户数组
     */
    public void show(String name, String pwd, User[] users) {

        // 查询用户的英语和数学得分
        double eng = 0.0;
        double math = 0.0;

        System.out.println("用户名称\t英语成绩\t数学成绩");
        int num = findUser2(name, users);
        eng = users[num].getEnglish();
        math = users[num].getMath();
        System.out.printf("%s\t%.1f\t%.1f\n", name, eng, math);

    }

    /********** End **********/
    public int findUser2(String name, User[] users) {
        int num = -1;
        // 根据用户名查找用户数组中是否已存在该用户，
        for (int i = 0; i < users.length; i++) {
            if (users[i] != null && name.equals(users[i].getName())) {
                num = i;
                break;
            }
        }
        return num;
    }

}
