/**
 * 编写一个学校接待方面的程序，招待不同身份的人的食宿问题
 * 本文件有一个 共享接口 Person
 * 还有两个接口实现类 Student 和 Teacher
 */

// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

/********** Begin **********/

// 定义一个接口类 Person
interface Person {
    // 定义 eat()，实现输出吃饭的功能，无返回值
    public void eat();

    // 定义 sleep()，实现睡觉的功能，无返回值
    public void sleep();
}

// 定义一个 Student 类并实现 Person 接口
class Student implements Person {
    // 实现 eat()：输出：“学生去食堂吃饭。”；
    @Override
    public void eat() {
        System.out.println("学生去食堂吃饭。");
    }

    // 实现 sleep()：输出：“学生在宿舍睡觉。”。
    @Override
    public void sleep() {
        System.out.println("学生在宿舍睡觉。");
    }
}

// 定义一个 Teacher 类并实现 Person 接口
class Teacher implements Person {
    // 实现 eat()：输出：“老师去教师食堂吃饭。”；

    @Override
    public void eat() {
        System.out.println("老师去教师食堂吃饭。");
    }

    // 实现 sleep()：输出：“老师在学校公寓睡觉。”。

    @Override
    public void sleep() {
        System.out.println("老师在学校公寓睡觉。");
    }
}


/********** End **********/
