/**
 * 通过图形类的计算面积的方法，计算矩形和三角形的面积。
 */
// 请在下面的Begin-End之间按照注释中给出的提示编写正确的代码

/********** Begin **********/
// 将 Shape 类改为抽象类
public abstract class Shape {

    public int width; // 几何图形的宽
    public int height; // 几何图形的高

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // 定义一个抽象方法 area()，返回值类型为 double，计算图形的面积
    public abstract double area();
}

// Rectangle 为矩形类，该类继承 Shape 类，并拥有 Shape 类的属性
class Rectangle {

    int x;
    int y;

    Rectangle(int a, int b) {
        x = a;
        y = b;
    }

    // 定义一个有参构造器
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 重写抽象方法 area，计算矩形的面积（高*宽），并将计算结果返回
    public double area() {
        return x * y;
    }
}

// Triangle 为矩形类，该类继承 Shape 类，并拥有 Shape 类的属性
class Triangle {

    int x;
    int y;

    Triangle(int a, int b) {
        x = a;
        y = b;
    }

    // 定义一个有参构造器
    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 重写抽象方法 area，计算三角形的面积（高\*宽/2），并将计算结果返回
    public double area() {
        return x * y / 2;
    }


}
/********** End **********/