package prototype_pattern;

/**
 * @ClassName Circle
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:43
 * @Version 1.0
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}