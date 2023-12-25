/*交换两个变量的值。输入任意两个整数，分别存入变量data1 和data2，交换两个变量的值。输出交换前和交换后的两个变量的值。*/

import java.util.Scanner;

public class ExchangeData {
    public static void main(String[] args) {
        int data1, data2, temp;  //data1和data2表示输入的两个整数，temp为中间变量
        //（1）输入 两个整数，分别赋给data1和data2
        Scanner scanner = new Scanner(System.in);
        data1 = scanner.nextInt();
        data2 = scanner.nextInt();


        System.out.printf("交换前：data1=%d,data2=%d\n", data1, data2);
        //(2)交换 data1 和data2的值
        temp = data1;
        data1 = data2;
        data2 = temp;

        //输出结果
        System.out.printf("交换后：data1=%d,data2=%d\n", data1, data2);
    }
}