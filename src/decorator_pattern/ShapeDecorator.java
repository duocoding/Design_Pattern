package decorator_pattern;

/**
 * @ClassName ShapeDecorator
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/4 16:35
 * @Version 1.0
 */
public abstract class ShapeDecorator implements Shape{
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    public void draw() {
        decoratedShape.draw();
    }
}
