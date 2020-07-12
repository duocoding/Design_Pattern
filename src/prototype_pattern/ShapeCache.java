package prototype_pattern;

import java.util.HashMap;

/**
 * @ClassName ShapeCache
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/12 8:43
 * @Version 1.0
 */
public class ShapeCache {

    public static HashMap<String, Shape> shapeCache = new HashMap<String, Shape>();

    public static Shape getShape(String id) {
        Shape cacheShape = shapeCache.get(id);
        return (Shape) cacheShape.clone();
    }

    public static void loadCache() {
        Circle circle = new Circle();
        circle.setId("1");

        Square square = new Square();
        square.setId("2");

        Rectangle rectangle = new Rectangle();
        rectangle.setId("3");

        shapeCache.put("1",circle);
        shapeCache.put("2",square);
        shapeCache.put("3",rectangle);
    }
}
