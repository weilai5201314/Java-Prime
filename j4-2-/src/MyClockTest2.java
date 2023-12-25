//主程序类，定义两个时钟对象，输入一个时间值，初始化时钟对象1，然后输出两个时钟的值。

import java.util.Scanner;

public class MyClockTest2 {

    public static void main(String[] args) {
        MyClock2 clock1, clock2;
        clock1 = new MyClock2();
        clock2 = new MyClock2();
        //输入一个时间：时 分 秒
        Scanner sc = new Scanner(System.in);
        int hour, minute, second;
        System.out.println("输入一个时间：（时 分 秒用空格分隔）");
        hour = sc.nextInt();
        minute = sc.nextInt();
        second = sc.nextInt();
        //用输入的时间设置时间对象clock1
        clock1.setClock(hour, minute, second);
        //显示两个时间对象
        clock1.display();
        clock2.display();
    }

}