package factory_pattern;

/**
 * @Auther: qulingxiao
 * @Date: 2020/6/13 11:30
 * @Description:
 */
public class UsingFactory {

    public int caculateUsingFactory(int a, int b, String operator){
        Operation targetOperation = OperatorFactory
                .getOperation(operator)
                .orElseThrow( () -> new IllegalArgumentException("Invalid operator"));
        return targetOperation.execute(a,b);
    }

    public static void main(String[] args) {
        System.out.println(new UsingFactory().caculateUsingFactory(4, 3, OperatorFactory.modulo));
    }

}
