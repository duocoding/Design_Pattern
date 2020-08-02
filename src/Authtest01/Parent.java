package Authtest01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName Parent
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 22:13
 * @Version 1.0
 */
public class Parent {

    public void print(int num){

        List<Character> resList = new ArrayList<>();

        HashMap<Integer, Character> map = new HashMap();
        map.put(0, '0');
        map.put(1, '1');
        map.put(2, '2');
        map.put(3, '3');
        map.put(4, '4');
        map.put(5, '5');
        map.put(6, '6');
        map.put(7, '7');
        map.put(8, '8');
        map.put(9, '9');
        map.put(10, 'A');
        map.put(11, 'B');
        map.put(12, 'C');
        map.put(13, 'D');
        map.put(14, 'E');
        map.put(15, 'F');

        while (num > 0){
            resList.add(0, map.get(num%16));
            num/=16;
        }
        for (Character character: resList){
            System.out.print(character);
        }
    }
}
