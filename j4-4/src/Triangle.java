/**
 * 任务：根据键盘输入的三个 double 型的数字判断其是否能构成三角形。
 * 类名为：Triangle
 */

import java.util.Scanner;

public class Triangle {

    // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
    /********** Begin **********/

    /**
     * 定义一个静态方法，该方法检验三边是否能构成三角形，携带三个参数，分别为传来的三个参数，无返回值
     * 如果能构成，不换行输出：这三条边可以构成三角形
     * 如果不能，不换行输出：这三条边不能构成三角形
     */

    static boolean panduan(double a, double b, double c) {
        return (a + b) > c && (b + c) > a && (a + c) > b;
    }


    // 定义主方法
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        boolean answer = panduan(a, b, c);
        if (answer)
            System.out.printf("这三条边可以构成三角形");
        else
            System.out.printf("这三条边不能构成三角形");
    }

    // 获取键盘输入的三个数


    // 通过类名.方法名的方式调用检验三边是否能构成三角形的方法，分别将键盘输入的三个数传入该方法中

    /********** End **********/
}
