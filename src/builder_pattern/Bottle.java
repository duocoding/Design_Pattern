package builder_pattern;

/**
 * @ClassName Bottle
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/7/18 10:38
 * @Version 1.0
 */
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "bottle packing";
    }
}
