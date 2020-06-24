package factory_pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @Auther: qulingxiao
 * @Date: 2020/6/13 11:20
 * @Description:
 */
public class OperatorFactory {

    private static Map<String, Operation> map = new HashMap<String, Operation>();

    public static String add = "add";
    public static String divide = "divide";
    public static String multiply = "multiply";
    public static String subtract = "subtract";
    public static String modulo = "modulo";

    static {
        map.put("add", new Addition());
        map.put("divide", new Division());
        map.put("multiply", new Multiplication());
        map.put("subtract", new Subtraction());
        map.put("modulo", new Modulo());
    }

    public static Optional<Operation> getOperation (String operator) {
        return Optional.ofNullable(map.get(operator));
    }
}
