/*请下面标注【】的位置添加代码*/

import java.util.Scanner;

public class CheckID {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();      //输入一个标识符
        //调用方法checkId(str)检查标识符str是否合法
        if (checkId(str))
            System.out.printf("%s合法", str);
        else
            System.out.printf("%s不合法", str);
        sc.close();
    }

    //定义方法checkId()，合法则返回ture，否则返回false
    public static boolean checkId(String str) {
        //定义正则表达式，描述标识符的组成规则
        String regex = "[a-zA-Z_]+[a-zA-Z0-9$_]";
        //判断字符串str是否与正则表达式匹配
        if (str.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }
}