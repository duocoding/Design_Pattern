package decorator_pattern;

/**
 * @ClassName DecoratorPatternDemo
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/4 16:41
 * @Version 1.0
 */
public class DecoratorPatternDemo {

    public static void main(String[] args) {

        Shape circle = new Circle();

        ShapeDecorator redCircle = new RedShapeDecorator(new Circle());

        ShapeDecorator redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();
    }
}
