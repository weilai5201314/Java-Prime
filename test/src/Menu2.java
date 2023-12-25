/*编程实现： 显示菜单（如下图），提示用户选择菜单项，根据用户的选择输出不同的结果。
若用户输入2，则输出“开始减法练习……”。若输入的数据超出1~5，则输出“输入错误，超出菜单范围”

小学生算术练习系统
1.加法练习
2.减法练习
3.乘法练习
4.除法练习
5.退出系统
*/

import java.util.Scanner;

public class Menu2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int choice;
        System.out.println("小学生算术练习系统");
        System.out.println("1.加法练习");
        System.out.println("2.减法练习");
        System.out.println("3.乘法练习");
        System.out.println("4.除法练习");
        System.out.println("5.退出系统");
        //提示用户输入选择（1-5）
        System.out.println("请选择（1-5）");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
        //根据用户的选择输出对应的信息
        switch (choice) {
            case 1:
                System.out.printf("开始加法练习");
                break;
            case 2:
                System.out.printf("开始减法练习");
                break;
            case 3:
                System.out.printf("开始乘法练习");
                break;
            case 4:
                System.out.printf("开始除法练习");
                break;
            case 5:
                System.out.printf("谢谢使用");
                break;
            default:
                System.out.printf("输入错误，超出菜单范围");

        }
    }
}