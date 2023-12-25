/*
在主程序类中定义两个时钟对象，时钟对象1初始化为（0：0：0）；输入一个时间，初始化时钟对象2，然后输出两个时钟的值。
*/
import java.util.Scanner;

public class MyClockTest3 {

    public static void main(String[] args) {
        MyClock3 clock1,clock2;
        clock1 = new MyClock3(0,0,0);

        //输入一个时间：时 分 秒
        Scanner sc = new Scanner(System.in);
        int hour,minute,second;
        System.out.println("输入一个时间：（时 分 秒用空格分隔）");
		 hour=sc.nextInt();
         minute=sc.nextInt();
         second=sc.nextInt();
        //用输入的时间初始化时间对象clock2
        clock2 = new MyClock3(hour,minute,second);
        //显示两个时间对象
        clock1.display();
        clock2.display();
        //用输入的时间设置clock1并显示
        clock1=clock2;
        clock1.display();
    }
}