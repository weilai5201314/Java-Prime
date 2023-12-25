/*编程实现邮局寄包裹的邮费计算：用户输入包裹的重量，按如下规定计算邮费。
 * 邮局对包裹邮费规定如下：重量（千克）不超过10，收费标准为0.80元/千克；
 * 不超过20，收费标准为0.75元/千克；不超过30，收费标准为0.70元/千克；
 * 超过30千克不予邮寄。另对每件包裹收手续费0.2元。
 * 若能邮寄，则输出格式为：包裹重量10.5KG，邮费8.1元
 */

import java.util.Scanner;

public class PostFee {

    public static void main(String[] args) {
        float weight, rate = 0, postFee;  //3个变量分表表示包裹的重量、邮费标准、需支付的邮费
        //提示用户输入包裹重量
        System.out.println("输入包裹重量（KG）");
        Scanner scanner = new Scanner(System.in);
        weight = scanner.nextFloat();
        //根据包裹的重量判断是否能够邮寄，若能邮寄则选择不同的计费标准 rate并计算邮费
        if (weight <= 10)
            rate = 0.8f;
        else if (weight <= 20)
            rate = 0.75f;
        else if (weight <= 30)
            rate = 0.7f;
        else {
            System.out.printf("不予邮寄");
            return;
        }
        postFee = weight * rate + 0.2f;
        System.out.printf("包裹重量%.1fKG，邮费%.1f元", weight, postFee);
    }
}