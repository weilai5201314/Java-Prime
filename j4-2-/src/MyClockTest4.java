/*在主程序类中输入一个时间，初始化clock1；然后用clock1 作为参数初始化clock2，然后输出两个时钟的值。
 请在下面的【】处补充代码。
 */

import java.util.Scanner;

public class MyClockTest4 {

    public static void main(String[] args) {
        MyClock4 clock1, clock2;

        //输入一个时间：时 分 秒
        System.out.println("输入一个时间：（时 分 秒用空格分隔）");
        Scanner sc = new Scanner(System.in);
        int hour, minute, second;
        hour = sc.nextInt();
        minute = sc.nextInt();
        second = sc.nextInt();
        //用输入的时间初始化时间对象clock1
        clock1 = new MyClock4(hour, minute, second);
        //用clock1初始化clock2
        clock2 = clock1;
        //显示两个时间对象
        clock1.display();
        clock2.display();
    }
}