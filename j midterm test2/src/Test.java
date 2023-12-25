public class Test {

    public static void main(String[] args) {
        User[] users = new User[50]; // 创建一个对象数组，用于存放所有的通讯录信息
        PhoneManage phoneManage = new PhoneManage();
        phoneManage.addPhone(users);
        phoneManage.addPhone(users);
        phoneManage.showPhone(users);
    }
}