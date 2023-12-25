    /**
     * 按照动物、宠物、猫和蜘蛛的关系，通过编程实现各自的关系并声明自己的属性和方法。
     * 动物类 Animal为抽象类，具有两个属性：种类和腿条数，并有 eat() 和 walk() 的方法；
     * 宠物 Pet 为接口，有三个功能：setName()、getName() 和 play()；
     * 蜘蛛类 Spider 继承动物类，重写 eat() 方法；
     * 猫类 Cat 继承动物类并实现宠物接口，本身有一个属性：名称。
     */

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

    /********** Begin **********/

    // 创建Animal类，它是所有动物的抽象父类
    abstract class Animal {
        // 声明一个受保护的字符串类型属性type，它记录动物的种类
        public static String type;
        // 声明一个受保护的整数类型属性legs，它记录动物的腿的数目
        public static int legs;

        // 定义一个受保护的有参构造器，用来初始化type和legs属性
        public Animal(String Type, int Legs) {
            type = Type;
            legs = Legs;
        }

        // 声明抽象方法eat，无返回值
        public abstract void eat();

        // 声明具体方法walk来打印动物是如何行走的（包括腿的数目）。
        public static void walk() {
            System.out.printf("%s用 %d 条腿走路\n",type, legs);
        }
        // 输出格式：用 xx 条腿走路
    }


    // 定义蜘蛛类 Spider继承Animal类
    class Spider extends Animal {
        // 定义默认构造器，它调用父类构造器来指明动物类别是spider，且所有蜘蛛都是8条腿。
        public Spider() {
            super("spider", 8);
        }

        // 实现eat方法，输出：spider eating
        public void eat() {
            System.out.println("spider eating");
        }

    }

    // 创建pet（宠物）接口
    interface pet {
        // 提供setName(String name) 为该宠物命名
        public void setName(String name);

        // 提供getName() 返回该宠物的名字，返回类型为String
        public String getName();

        // 提供 play()方法，无返回值
        public void play();
    }


    // 定义公开的猫类 Cat 继承动物类并实现宠物接口
    public class Cat extends Animal implements pet {

        // 定义一个name属性来存宠物的名字
        String name;

        // 定义一个有参构造器，它使用String参数指定猫的名字
        public Cat(String na) {
            super("cat", 4);
            name = na;
        }
        // 该构造器必须调用超类构造器来指明动物种类是cat，且所有的猫都是四条腿

        // 另定义一个无参的构造器。该构造器调用前一个构造器（用this关键字）并传递一个空字符串作为参数
        public Cat() {
            this("");

        }

        // 实现 Pet接口的方法
        // 设置猫的名称

        @Override
        public void setName(String name) {
            this.name = name;
        }

        // 获取猫的名称
        @Override
        public String getName() {
            return name;
        }

        // 重写 Animal 类的play()，输出：Cat is playing

        @Override
        public void play() {
            System.out.println("Cat is playing");
        }

        // 重写 Animal 类的eat()，输出：xx eating

        @Override
        public void eat() {
            System.out.printf("%s eating\n", name);
        }

        // xx 表示姓名

    }


    /********** End **********/