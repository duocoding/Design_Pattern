package Authtest01;

/**
 * @ClassName PalindromeInteger
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/28 22:42
 * @Version 1.0
 */
public class PalindromeInteger {
    public static void main(String[] args) {
        System.out.println(new PalindromeInteger().isPalindrome(10));
    }

    boolean isPalindrome(int x){
        int cur = x;
        if(x<0){
            return false;
        } else if(x == 0){
            return true;
        }
        int temp = 0;
        while (x > 0) {
            temp = temp*10+(x%10);
            x/=10;
        }
        return temp == cur;
    }
}
