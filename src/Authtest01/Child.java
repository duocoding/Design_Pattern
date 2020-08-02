package Authtest01;

/**
 * @ClassName Child
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/8/1 22:19
 * @Version 1.0
 */
public class Child extends Parent{

    @Override
    public void print(int num){
        System.out.println(num);
    }

    public static void main(String[] args) {

        Parent obj2 = new Child();
        obj2.print(456);

        Parent object = new Parent();
        object.print(456);

    }
}
