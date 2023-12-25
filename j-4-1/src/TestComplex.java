//调用复数类，请在下面的【】处填写代码
public class TestComplex {

    public static void main(String[] args) {
        //声明6个Complex类的对象c1~c6，其中前两个表示要运算的两个复数，后4个表示加减乘除的结果

        //创建2个对象c1和c2
        Complex c1=new Complex();
        Complex c2=new Complex();
        Complex c3,c4,c5,c6;
//        Complex c3=new Complex();
//        Complex c4=new Complex();
//        Complex c5=new Complex();
//        Complex c6=new Complex();


        //设置c1，c2的值，分别为  8+10i 、4+6i
        c1.set(8,10);
        c2.set(4,6);
        //调用add()方法计算两个复数的和，存入c3
        c3=c1.add(c2);
        //调用c3的方法display()显示c3的值
		c3.display();
        //调用减法，计算c1-c2，结果存入c4，显示c4的值
        c4=c1.sub(c2);
		c4.display();
        //调用乘法,计算c1*c2，结果存入c5，显示c5的值
        c5=c1.mul(c2);
		c5.display();
        //调用除法
        c6=c1.div(c2);
		c6.display();
    }

}