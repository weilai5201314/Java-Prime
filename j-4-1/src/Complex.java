//复数类的定义，请在下面的【】处填写代码
public class Complex {
    //数据成员: 实部、虚部，都是double类型
    //以下是方法成员
    // 设置复数
    double qian;
    double hou;
    void set(double r, double i)
    {
        qian =r;
        hou =i;
    }

    void display( ) // 显示复数，格式为 a + bi
    {
        System.out.printf("%.2f + %.2fi\n", qian, hou);
    }

    Complex add(Complex c2) // 两个复数相加
    {
        Complex c3=new Complex();
        c3.qian =this.qian + c2.qian;
        c3.hou =this.hou +c2.hou;
        return c3;
    }
    Complex sub(Complex c2) // 两个复数相减
    {
        Complex a=new Complex();
        a.qian =this.qian -c2.qian;
        a.hou =this.hou -c2.hou;
        return a;
    }
    //复数的乘积 （a+bi）*（c+di）=（ac-bd）+（bc+ad）i
    Complex mul(Complex c2)
    {
        Complex a=new Complex();
        a.qian =this.qian *c2.qian -this.hou *c2.hou;
        a.hou =this.hou *c2.qian +this.qian *c2.hou;
        return a;

    }
    /*复数的商:分子分母同时乘以分母的共轭复数
    (a+bi)/(c+di)	=((a+ bi)(c- di))/((c+ di)(c- di))
            =(ac+bd)/(c^2+d^2)+ ((bc-ad)/(c^2+d^2))i
    */
    Complex div(Complex c2)
    {
        Complex x=new Complex();

        x.qian=(this.qian*c2.qian+this.hou*c2.hou)/(c2.qian*c2.qian+c2.hou*c2.hou);
        x.hou=((this.hou*c2.qian-this.qian*c2.hou)/(c2.qian*c2.qian+c2.hou*c2.hou));
        return x;
    }
}