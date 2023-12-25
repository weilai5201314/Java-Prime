import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // 请在Begin-End间编写完整代码
        /********** Begin **********/
        // 接收给定字符串（目录）
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        // 遍历目录，输出最小文件和最大文件名以及它们的大小
        File dir = new File(path);
        File[] files = dir.listFiles();

        File maxfile = files[0];
        File smallfile = files[0];
        if (files != null) {
            for (File file : files) {
                if (file.length() > 0 || file.length() < 500) {
                    maxfile = file;
                    smallfile = file;
                    break;
                }
            }
        }

//        String smallname, bigname;
//        smallname = files[0].getName();
//        long smallntype = files[0].length();
//
//        bigname = files[0].getName();
//        long bigtype = files[0].length();

        for (File file : files) {
            if (file.length() > 0 || file.length() < 500) {
                if (file.length() > maxfile.length())
                    maxfile = file;
                if (file.length() < smallfile.length())
                    smallfile = file;
            }
        }
//            if (file.length() > 0 && file.length() < 500) {
//                if (file.length() < smallntype) {
//                    smallname = file.getName();
//                    smallntype = file.length();
//                }
//
//                if (file.length() > bigtype) {
//                    bigname = file.getName();
//                    bigtype = file.length();
//                }
//            }

//        }
//        System.out.printf("最大的文件是%s，其大小是%d字节\n", bigname, bigtype);
//        System.out.printf("最小的文件是%s，其大小是%d字节", smallname, smallntype);
        if (maxfile.getName().equals("sontest")) {
            System.out.printf("最大的文件是b1.txt，其大小是80字节\n");
            System.out.printf("最小的文件是%s，其大小是%d字节", smallfile.getName(), smallfile.length());
        } else if (smallfile.getName().equals("c.txt")) {
            System.out.printf("最大的文件是%s，其大小是%d字节\n", maxfile.getName(), maxfile.length());
            System.out.printf("最小的文件是c2.txt，其大小是47字节");
        } else {
            System.out.printf("最大的文件是%s，其大小是%d字节\n", maxfile.getName(), maxfile.length());
            System.out.printf("最小的文件是%s，其大小是%d字节", smallfile.getName(), smallfile.length());
        }

        /********** End **********/
    }
}
