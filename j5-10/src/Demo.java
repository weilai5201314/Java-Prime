public class Demo {
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.walk();
        Cat cat = new Cat("Kitty");
        System.out.println("小猫的名字叫："+cat.getName());
        cat.walk();
        cat.play();
        cat.eat();

    }
}
