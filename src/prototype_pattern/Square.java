package prototype_pattern;

/**
 * @ClassName Square
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:42
 * @Version 1.0
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}