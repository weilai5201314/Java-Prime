/* 在上一关的基础上，添加一个不带参数的构造方法，给数据成员置0；一个带参数的构造方法；
在主程序类中定义两个时钟对象，输入一个时间，初始化时钟对象2，然后输出两个时钟的值。
*/
public class MyClock3 {
    //数据成员: 时  分 秒
    int hour, minute, second;

    //方法成员：构造方法1--不带参数的，初始化时钟为 0：0：0
    MyClock3() {
    }

    //方法成员：构造方法2-- 带参数的，三个参数分别（ 时，分，秒）
    MyClock3(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //方法成员:设置时间
    public void setClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;

    }

    //方法成员: 显示时间
    public void display() {
        System.out.printf("%2d:%2d:%2d\n", this.hour, this.minute, this.second);
    }
}