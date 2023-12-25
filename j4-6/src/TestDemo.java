import java.util.Scanner;
import java.lang.Integer;

import static java.lang.Integer.*;

public class TestDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        int b=a;
        // 请在下面的Begin-End之间编写正确的代码
        /********* Begin *********/
        System.out.printf("最大值：%d\n",MAX_VALUE);
        System.out.printf("最小值：%d\n",MIN_VALUE);
        String c=toBinaryString(b);
        System.out.printf("a的二进制值为：%s\n",c);
        c=toOctalString(b);
        System.out.printf("a的八进制值为：%s\n",c);

        System.out.printf("int类型的二进制位数为：%s\n",32);

        /********** End **********/
    }
}