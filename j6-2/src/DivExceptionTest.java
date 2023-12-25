import java.util.Scanner;

public class DivExceptionTest {
    public static void main(String[] args) {
        int num1, num2;
        /********* Begin *********/
        //输入两个整数num1,num2
        Scanner sc = new Scanner(System.in);
        num1 = sc.nextInt();
        num2 = sc.nextInt();
        try {
            //计算并输出结果，对除数为0的异常进行处理
            System.out.println(num1 / num2);
        } catch (Exception e) {
            System.out.println("除数不能为0");
        }

    }
}
/********* End *********/



