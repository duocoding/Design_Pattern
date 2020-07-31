package Authtest01;

/**
 * @Auther: qulingxiao
 * @Date: 2020/7/28 16:19
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        String s= "   -42";
        System.out.println(new Main().myAtoi(s));
    }
    public int myAtoi(String str) {

        long num=0;
        boolean positive=true;
        int i=0;
        str = str.trim();
        if(i<str.length() && (str.charAt(i)=='-' || str.charAt(i)=='+'))
        {
            if(str.charAt(i)=='-')
                positive=false;
            i++;
        }
        while(i<str.length() && Character.isDigit(str.charAt(i)))
        {
            num=num*10+(str.charAt(i)-'0');
            if(positive && num>Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(!positive && num>Integer.MAX_VALUE)
                return Integer.MIN_VALUE;
            i++;
        }
        if(!positive)
            num=num*-1;
        return (int)num;
    }
}
