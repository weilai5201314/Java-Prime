/*请在下面的【】位置补充代码。可以用String类或StringBuffer类实现，最好是两种方法都试一试*/

import java.util.Scanner;

public class InputText {
    public static void main(String[] args) {
        //创建两个字符串对象str1和 str2，其中str1用于保存文章，str2用于接收刚输入的一行字符

        StringBuffer str1 = new StringBuffer();
        String str2;
        System.out.println("输入文章内容，以*结束:");
        //创建输入对象
        Scanner sc = new Scanner(System.in);
        while (true) {
            //输入一行字符str2
            str2 = sc.nextLine();
            //判断刚输入的字符串是否为“*” ，若是，则退出循环
            if (str2.equals("*"))
                break;
            //将输入的字符串str2连接在原来的字符串str1后面
            str1.append(str2);
        }
        System.out.println("文章内容：" + str1);
        System.out.println("长度：" + str1.length());
        sc.close();
    }
}
