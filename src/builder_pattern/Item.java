package builder_pattern;

/**
 * InterfaceName Item
 *
 * @Author qulingxiao
 * @Date 2020/7/18 10:34
 * @Version 1.0
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}
