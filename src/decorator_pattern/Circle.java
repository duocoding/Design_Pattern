package decorator_pattern;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/4 16:35
 * @Version 1.0
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Circle");
    }
}
