import java.util.Scanner;

public class Str {

    public static void main(String[] args) {

        // 请在Begin-End间编写代码
        /********** Begin **********/
        Scanner sc = new Scanner(System.in);
        // 第一步：接收给定的字符串
        String revc = sc.nextLine();
        // 第二步：创建StringBuffer对象
        StringBuffer str1 = new StringBuffer();
        // 第三步：切割字符串
        String[] words = revc.split(" ");
        // 第四步：反转单词
        for (String word : words) {
            StringBuffer midword = new StringBuffer(word);
            midword.reverse();
            str1.append(midword).append(" ");
        }
        String result = str1.toString().trim();
        // 第五步：输出反转后的字符串
        System.out.printf("反转后的字符串：%s", result);
        /********** End **********/

    }
}
