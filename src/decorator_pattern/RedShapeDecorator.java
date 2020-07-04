package decorator_pattern;

/**
 * @ClassName RedShapeDecorator
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/4 16:37
 * @Version 1.0
 */
public class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color: Red");
    }
}
