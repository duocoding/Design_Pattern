package builder_pattern;

/**
 * @ClassName ChickenBurger
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:44
 * @Version 1.0
 */
public class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
