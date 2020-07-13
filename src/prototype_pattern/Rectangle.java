package prototype_pattern;

/**
 * @ClassName Rectangle
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:40
 * @Version 1.0
 */
public class Rectangle extends Shape{

    public Rectangle(){
        type = "Rectangle";
    }
    @Override
    void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
