/*测试圆锥类，输入底面圆的半径、高度，计算并输出圆锥的半径、底面积、高、体积*/

import java.util.Scanner;

public class ConeTest {

    public static void main(String[] args) {
        Circle circle=new Circle();
        Cone cone = new Cone(circle);
        Scanner sc = new Scanner(System.in);
        double radius, height;
        radius = sc.nextDouble();
        height = sc.nextDouble();
        cone.set(radius, height);
        cone.disaplay();
    }

}