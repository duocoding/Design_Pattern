package Authtest01;

import java.util.HashMap;

/**
 * @ClassName RomanNumbers
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/28 22:58
 * @Version 1.0
 */
public class RomanNumbers {
    public static void main(String[] args) {
        System.out.println(new RomanNumbers().romanToInt("MDCXCV"));
    }
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = map.get(s.charAt(s.length() -1));
        int current;
        int prev = result;
        for(int i = s.length() -2 ; i >= 0; i--){
            current = map.get(s.charAt(i));
            if(prev > current)
                result -= current;
            else
                result += current;
            prev = current;
        }
        return result;
    }
}
