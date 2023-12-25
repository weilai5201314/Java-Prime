/*
 * 将 Double 类转换成其他数据类型。
 */

import java.lang.Integer;
import java.lang.Double;

public class Demo {
    public static void main(String[] args) {
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********** Begin **********/
        // 定义int类型变量，值为67，命名为score
        int score=67;
        // 创建Double包装类对象，表示变量score的值，命名为score1
        Double score1= Double.valueOf(score);
        // 将Double包装类转换为double类型，命名为score2
        double score2=score1.doubleValue();
        // 将Double包装类转换为float类型，命名为score3
        float score3=score1.floatValue();
        // 将Double包装类转换为int类型，命名为score4
        int score4= score1.intValue();

        /********** End **********/

        System.out.println("Double包装类：" + score1);
        System.out.println("double类型：" + score2);
        System.out.println("float类型：" + score3);
        System.out.println("int类型：" + score4);
    }
}