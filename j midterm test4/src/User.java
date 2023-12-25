// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
/********** Begin **********/
// 定义 User 公开类
public class User {
    // 用户的两个私有属性：姓名、电话号码
    private String name; // 用户姓名
    private String tel; // 用户电话号码

    // 无参构造
    public User() {
    }
    // 有参构造
    public User(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    // 设置和获取用户属性信息
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


}
/********** End **********/