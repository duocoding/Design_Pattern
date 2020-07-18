package builder_pattern;

/**
 * @ClassName Coke
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:44
 * @Version 1.0
 */
public class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 30.0f;
    }
}
