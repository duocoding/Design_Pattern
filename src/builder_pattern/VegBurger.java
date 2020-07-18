package builder_pattern;

/**
 * @ClassName VegBurger
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:43
 * @Version 1.0
 */
public class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
