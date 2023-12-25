/*整数拆分。输入任意一个三位的整数，计算其百位、十位、个位数。
 * 若输入478，则输出格式为：百位4十位7个位8*/

import java.util.Scanner;

public class SplitInteger {
    public static void main(String[] args) {
        int data;  //data表示输入的整数
        int bai,shi,ge;  //表示百位、十位、个位数
        //（1）输入整数，赋给data
        Scanner scanner=new Scanner(System.in);
        data=scanner.nextInt();

        //(2)拆分：计算百位、十位、个位数
        bai=data/100;
        shi=(data/10)%10;
        ge=data%10;

        //（3）输出结果
        System.out.printf("百位%d十位%d个位%d",bai,shi,ge);
    }
}
