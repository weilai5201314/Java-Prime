/**
 * 判断梨类、苹果类和水果类的关系，并通过对象类型转换调用彼此的属性和方法。
 */

class Fruits {
    public String name; // 定义水果名称

    Fruits(String name) {
        this.name = name;
    }
}

// 苹果类继承水果类
class Apple extends Fruits {

    public String acolor; // 苹果颜色

    public Apple(String name, String acolor) {
        super(name);
        this.acolor = acolor;
    }
}

// 梨类继承水果类
class Pear extends Fruits {
    public String pcolor; // 梨的颜色

    public Pear(String name, String pcolor) {
        super(name);
        this.pcolor = pcolor;
    }
}

public class Tests {
    public static void main(String args[]) {
        Fruits f = new Fruits("水果");
        Apple a = new Apple("苹果", "red");
        Pear p = new Pear("；梨", "yellow");
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********* Begin *********/
        // 依次判断 f、a、p是否为 Fruits的子类对象
        System.out.println(f instanceof Fruits);
        System.out.println(a instanceof Fruits);
        System.out.println(p instanceof Fruits);
        // 把梨类对象赋值给水果类，其中name值为bigPear,颜色为green
        f = p;
        f.name = "bigPear";
        ((Pear) f).pcolor = "green";
        // 输出当前水果类引用的名称
        System.out.println(f.name);
        // 依次判断当前水果类引用是否为水果类和梨类的子类
        System.out.println(f instanceof Fruits);
        System.out.println(f instanceof Pear);
        // 将当前水果类引用强转为梨类
//        f = new Pear("bigName", "green");
        f = p;
        // 输出当前梨类的颜色
        System.out.println(((Pear) f).pcolor);
        System.out.println(p.pcolor);
        /********** End **********/
    }
}