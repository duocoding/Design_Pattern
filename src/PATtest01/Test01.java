package PATtest01;

import java.util.Scanner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/10 22:35
 * @Version 1.0
 */
public class Test01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(operator(n));
    }

    public static Integer operator(int n) {
        int count = 0;
        while (n!=1){
            if(n%2==0){
                n/=2;
            }else {
                n=(n*3+1)/2;
            }
            count++;
        }
        return count;
    }
}
