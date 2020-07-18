package builder_pattern;

/**
 * @ClassName Burger
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:39
 * @Version 1.0
 */
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
