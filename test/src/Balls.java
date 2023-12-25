/*取红黑白球：盒子里共有12个球，其中3个红球、3个白球、6个黑球，从中任取8个球，问至少有一个红球的的取法有多少种？*/


public class Balls {

    public static void main(String[] args) {
        int red, black, white;
        int num = 0;
        //请在下面补充代码

        for (red = 1; red < 4; red++)
            for (white = 0; white < 4; white++)
                for (black = 0; black < 7; black++)
                    if (red + white + black == 8)
                        num++;

        System.out.printf("%d", num);


    }
}