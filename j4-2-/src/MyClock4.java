/*（1）定义一个时钟类MyClock，包含3个数据成员（即成员变量：时，分，秒）；包含2个方法，一个显示时间的方法display(),按照“ 12:28:45 ”的格式显示时间。
(2)在前面两关的基础上，添加一个用时钟对象作为参数的构造方法。
*/
public class MyClock4 {
    //数据成员:时，分，秒
    int hour, minute, second;
    MyClock4 clock1, clock2;

    //方法成员：构造方法1--不带参数的，初始化对象为 0：0：0
    MyClock4() {
    }

    //方法成员：构造方法2-- 带参数的，用时、分、秒初始化对象
    MyClock4(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //方法成员：构造方法3-- 用对象作为参数
    MyClock4(MyClock4 clock) {
        this.hour = clock.hour;
        this.minute = clock.minute;
        this.second = clock.second;
    }


    //方法成员: 显示时间
    public void display() {
    System.out.printf("%2d:%2d:%2d\n",this.hour,this.minute,this.second);
    }
}