/**
 * 任务：使用 instanceof 运算符判断所给对象是否为特定类的一个实例，并输出判断结果。
 */


public class Demo {
    public static void main(String[] args){
        // 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码
        /********** Begin **********/
        Object hello = "Hello";
        // 判断hello是否是Object类的实例
        System.out.println(hello instanceof Object);
        // 判断hello是否是String类的实例
        System.out.println(hello instanceof String);
        // 判断hello是否是Math类的实例
        System.out.println(hello instanceof Math);
        // 判断a是否是Object类的实例
        String a = "hello";
        System.out.println(a instanceof Object);
    }
}