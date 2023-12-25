public class TestFriends {
    public static void main(String[] args) {
        Friends s1 = new Friends();
        Friends s2 = new Friends();
        s1.set("王丽艳", "13245876655", "山东交通学院信电学院", 21, "计算机19");
        s2.set("逄瀚", "15678908899", "机动车检测中心", 34, "经理");
        s1.display();
        s2.display();
    }
}