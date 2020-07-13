package easy_test;

import java.util.Scanner;

/**
 * @Auther: qulingxiao
 * @Date: 2020/7/13 16:20
 * @Description:
 */
public class DynamicSimpleTest {

    private static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(totolStep(n));
    }

    public static int totolStep(int n){
        int [] arrays = new int[n+1];
        arrays[0] = 0;
        arrays[1] = 1;
        arrays[2] = 2;
        for(int i= 3; i<= n; i++){
            arrays[i] = arrays[i-1]+arrays[i-2];
        }
        return arrays[n];
    }
}
