/*请在下面标注【】的位置添加代码*/
//定义接口Speak，包含一个方法speak()
interface Speak {
    public void speak();
}

//测试类
public class TestInterface {
    public static void main(String[] args) {

        // 第一种，匿名类
//        Speak hello = new Speak() {
//            @Override
//            public void speak() {
//                System.out.println("大家好，请多关照！");
//            }
//        };

        // 第二种，lambda表达式
        Speak hello = () -> {
            System.out.println("大家好，请多关照！");
        };
        
        hello.speak();
    }
}