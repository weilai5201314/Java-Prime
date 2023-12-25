/*朋友信息类，请在下面的【】处补充代码*/
public class Friends {
    //数据成员:姓名、电话、单位、年龄、备注
    //方法成员
    //设置朋友信息
    String name;
    String tel;
    String workUnit;
    int age;
    String note;

    void set(String name, String tel, String workUnit, int age, String note) {
        this.name = name; // this 指代成员变量 或方法
        this.tel = tel;
        this.workUnit = workUnit;
        this.age = age;
        this.note = note;
    }

    //显示信息
    void display() {
        System.out.printf("name:%s tel:%s workUnit:%s age:%d note:%s\n", name, tel, workUnit, age, note);
    }
}

