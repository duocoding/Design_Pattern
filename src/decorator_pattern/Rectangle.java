package decorator_pattern;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/4 16:33
 * @Version 1.0
 */
public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}
