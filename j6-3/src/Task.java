package step3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task {
    /********* Begin *********/
    //请在合适的部位添加代码
    public static void main(String[] args) throws FileNotFoundException {
        test();
    }

    public static void test() throws FileNotFoundException {
        File file = new File("abc");
        if (!file.exists()) {        //判断文件是否存在
            //文件不存在，则 抛出 文件不存在异常
            throw new FileNotFoundException("该文件不存在");
        } else {
            FileInputStream fs = new FileInputStream(file);
        }
    }
    /********* End *********/
}



