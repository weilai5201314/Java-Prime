/**
 * 任务：定义一个三角形 Triangle 类，继承 Shape 类，
 * 在这个类中分别定义一个名为 area 的方法，实现计算该形状面积的功能。
 * 类名为：Triangle
 */

// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

/********** Begin **********/
// 定义一个Triangle的公开类，并继承Shape类
public class Triangle extends Shape {

    double area1 = 0;
    Shape shape=new Shape();
    public double area() {
        area1 = (getHeight() * getWidth()) / 2;
        return area1;
    }
}
// 定义一个area方法，实现计算矩形面积的功能。

/********** End **********/