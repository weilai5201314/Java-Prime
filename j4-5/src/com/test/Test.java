// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
/********** Begin **********/
// 声明一个名为 com.test 的包
package com.test;
// 导入 Movie 类

import com.model.Movie;
// 导入 java.util.Scanner 类
import java.util.Scanner;

// 定义一个公开的 Test 类
public class Test {
    // 定义主方法
    public static void main(String[] args) {
        // 实例化 Movie 对象
        Movie mv = new Movie();

        // 将键盘四次输入的电影信息赋值给 Movie 对象
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String model = sc.nextLine();
        String time = sc.nextLine();
        String area = sc.nextLine();
        mv.set(name, model, time, area);

        // 调用获取 Movie 信息的方法
        mv.display();
    }


}


/********** End **********/