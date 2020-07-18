package builder_pattern;

/**
 * @ClassName Pepsi
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:45
 * @Version 1.0
 */
public class Pepsi extends ColdDrink{
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 35.0f;
    }
}
