import java.io.*;
import java.util.Scanner;

public class FileTest {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in); // 创建一个Scanner对象用于用户输入
        String javaFile = scanner.next(); // 从用户输入中获取文件路径
        // 请在Begin-End间编写完整代码
        /********** Begin **********/
        Reader in = new FileReader(javaFile); // 创建文件读取流
        BufferedReader bin = new BufferedReader(in); // 创建缓冲字符读取流
        StringBuffer sb = new StringBuffer(); // 创建可变字符串用于存储文件内容
        String s; // 初始化字符串s
        // 将内容保存到可变字符串
        while ((s = bin.readLine()) != null) { // 逐行读取文件内容
            // 先去掉空格，再判断是否是注释开头，如果是就追加
            if (!s.trim().startsWith("//")) { // 判断是否以"//"开头
                sb.append(s); // 追加字符串到可变字符串
                sb.append("\r\n"); // 在可变字符串中添加换行符
            }
        }
        bin.close(); // 关闭缓冲字符读取流
        in.close(); // 关闭文件读取流
        // 将sb转为String，用bout将其写入文件
        Writer out = new FileWriter(javaFile); // 创建文件写入流
        BufferedWriter bout = new BufferedWriter(out); // 创建缓冲字符写入流
        s = sb.toString(); // 将可变字符串转为字符串
        bout.write(s); // 将字符串写入文件
        // 关闭上层流
        bout.close(); // 关闭缓冲字符写入流
        // 关闭下层流
        out.close(); // 关闭文件写入流
        File file = new File(javaFile); // 创建文件对象
        System.out.printf("文件长度：%d", file.length()); // 打印文件长度

        /********** End **********/

    }
}
