/*输入两个正整数，求它们的最小公倍数*/
import java.util.Scanner;

public class Multiple {

    public static void main(String[] args) {
        int m,n,multiple,big;
        //输入两个整数，分别赋给m、n
        Scanner scanner=new Scanner(System.in);
        m=scanner.nextInt();
        n=scanner.nextInt();

        //找出m和n中的较大值big
        if(m<n)
            big=n;
        else
            big=m;
        multiple=big;
        //找m和n最小公倍数
        while (multiple%m!=0||multiple%n!=0)
            multiple++;
        System.out.printf("%d",multiple);
    }
}