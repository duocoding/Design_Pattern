package factory_pattern;

/**
 * @Auther: qulingxiao
 * @Date: 2020/6/13 11:18
 * @Description:
 */
public class Subtraction implements Operation {
    @Override
    public int execute(int a, int b) {
        return a-b;
    }
}
