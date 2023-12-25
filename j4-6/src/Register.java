// 在 Register 类中创建 validateUser(String userName,String passWord) 方法，校验用户输入的用户名和密码是否合格。

import java.lang.String;
import java.lang.Character;

import static java.lang.Character.*;

public class Register {
    // 校验用户输入的用户名和密码是否合格
    public static boolean validateUser(String userName, String passWord) {
        boolean isUser = false;
        boolean isPwd = false;
        // 判断用户名是否为空，如果为空，输出：用户名不能为空！
        if (userName.length() == 0) {
            System.out.println("用户名不能为空！");
//            return false;
        }
        // 如果用户名不为空，验证用户名是否全部为字母，不能含有空格
        // 如果验证失败，输出：用户名只能由字母组成，且不能含有空格！
        if (userName.length() > 0) {
            for (int i = 0; i < userName.length(); i++) {
                char c = userName.charAt(i);
                if (isLetter(c)) {
                    isUser = true;
                } else {
                    isUser = false;
                    System.out.println("用户名只能由字母组成，且不能含有空格！");
                    break;
                }
            }
        }
        // 判断密码是否为空，如果为空，输出：密码不能为空！
        if (passWord.length() == 0) {
            System.out.println("密码不能为空！");
//            return false;
        }
        // 如果密码不为空，密码只能是字母或数字组合而成
        // 如果验证失败，输出：密码只能是字母或数字组合而成！
        if (passWord.length() > 0) {
            for (int i = 0; i < passWord.length(); i++) {
                char c = passWord.charAt(i);
                if (isLetterOrDigit(c)) {
                    isPwd = true;
                } else {
                    isPwd = false;
                    System.out.println("密码只能是字母或数字组合而成");
                    break;
                }
            }
        }
        // 如果用户名和密码都验证成功，返回ture
        // 如果用户名或密码验证失败，返回false
        if (isUser == true && isPwd == true)
            return true;
        else
            return false;
    }
}
