package prototype_pattern;

/**
 * @ClassName PrototypePatternDemo
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:48
 * @Version 1.0
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {

        ShapeCache.loadCache();

        Shape clonedShape = (Shape) ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape.getType());

        Shape clonedShape2 = (Shape) ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());

        Shape clonedShape3 = (Shape) ShapeCache.getShape("3");
        System.out.println("Shape : " + clonedShape3.getType());
    }
}
