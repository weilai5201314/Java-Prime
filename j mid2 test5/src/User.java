public class User {

    private String name; // 用户姓名
    private String pwd; // 密码
    private double math; // 数学成绩
    private double english; // 英语成绩

    // 无参构造
    public User() {

    }

    // 有参构造
    public User(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }


    // 设置和获取用户属性信息
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getMath() {
        return math;
    }

    public void setMath(double math) {
        this.math = math;
    }

    public double getEnglish() {
        return english;
    }

    public void setEnglish(double english) {
        this.english = english;
    }

}