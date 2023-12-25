/*（1）	定义一个时钟类MyClock，包含3个数据成员（即成员变量：时，分，秒）；
包含2个方法， 一个设置时间的方法setClock()，一个显示时间的方法display(),按照“ 12:28:45 ”的格式显示时间。
请在下面的【】处补充代码。
*/
public class MyClock2 {
    //数据成员：hour minute second
    int hour, minute, second;//方法成员:设置时间

    public void setClock(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    //方法成员: 显示时间
    public void display() {
        System.out.printf("%2d:%2d:%2d\n", hour, minute, second);
    }
}