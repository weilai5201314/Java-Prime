import java.io.*;
import java.util.Scanner;

public class FileTest {
    public static void main(String[] args) throws IOException {
        // 请在Begin-End间编写完整代码
        /********** Begin **********/
        // 使用字节输出流和输入流，把给定文件里的内容复制到另一个给定文件中
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        InputStream fin = new FileInputStream(str1);
        OutputStream fout = new FileOutputStream(str2);
        // 获取源文件长度
        File f1 = new File(str1);
        int len = (int) f1.length();
        byte[] b = new byte[len];
        // 通过fin读取文件信息
        fin.read(b);
        fout.write(b);
        fin.close();
        fout.close();

        /********** End **********/
    }
}
