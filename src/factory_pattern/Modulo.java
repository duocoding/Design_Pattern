package factory_pattern;

/**
 * @Auther: qulingxiao
 * @Date: 2020/6/13 11:20
 * @Description:
 */
public class Modulo implements Operation {
    @Override
    public int execute(int a, int b) {
        return a%b;
    }
}
