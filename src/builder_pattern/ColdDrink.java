package builder_pattern;

/**
 * @ClassName ColdDrink
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:41
 * @Version 1.0
 */
public abstract class ColdDrink implements Item{

    @Override
    public abstract float price();

    @Override
    public Packing packing() {
        return new Bottle();
    }
}
