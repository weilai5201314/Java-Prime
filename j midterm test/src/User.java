// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

/********** Begin **********/
// 定义 User 公开类
public class User {
    // 用户的两个私有属性：姓名、电话号码
    private String name;
    private String tel;

    // 无参构造
    public User() {
    }

    // 有参构造
    public User(String a, String b) {
        name = a;
        tel = b;
    }

    // 设置和获取用户属性信息
    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

}


/********** End **********/