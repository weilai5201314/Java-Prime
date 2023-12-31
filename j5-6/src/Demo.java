/**
 * 按照代码文件中提供的注释完成 Demo 类的编写，使得程序正常输出。
 */
class DemoTest{
    int i = 10;
}
// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
/********* Begin *********/

// 将Demo类改为 final形式
final class Demo{
    // 定义一个final、static常量，名为PI，值为3.14
    final static double PI=3.14;
    // 声明一个final类型的DemoTest对象，命名为demoTest
    final DemoTest demoTest=new DemoTest();
    // 声明一个不为final类型的DemoTest对象，命名为demoTest2
    DemoTest demoTest2;
    // 声明一个final型的数组，类型为int，值为 1,2,3，命名为a
    final int[] a = {1,2,3};
    // 删除主函数中错误的代码，使得程序能够正确输出
    public static void main(String[] args) {
        Demo demo = new Demo();
//        demo.demoTest = new DemoTest();
        System.out.println(demo.PI);
        demo.demoTest2 = new DemoTest();
        System.out.println(demo.demoTest2.i);
        for (int i = 0; i < demo.a.length; i++){
            demo.a[i] = 9;
            System.out.println(demo.a[i]);
        }
    }
}
/********** End **********/