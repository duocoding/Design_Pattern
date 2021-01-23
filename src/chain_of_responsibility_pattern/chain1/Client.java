package chain_of_responsibility_pattern.chain1;

/**
 * @author qulingxiao
 * @className Client
 * @description TODO
 * @since 2021/1/23 16:20
 */
public class Client {
    public static void main(String[] args) {
        AbstractHandler zhangsan = new Director("张三");
        AbstractHandler lisi = new Manager("李四");
        AbstractHandler wangwu = new TopManager("王五");

        // 创建责任链
        zhangsan.setNextHandler(lisi);
        lisi.setNextHandler(wangwu);

        // 发起请假申请
        boolean result1 = zhangsan.process(new LeaveRequest("001", 1));
        System.out.println("最终结果：" + result1 + "\n");

        boolean result2 = zhangsan.process(new LeaveRequest("002", 4));
        System.out.println("最终结果：" + result2 + "\n");

        boolean result3 = zhangsan.process(new LeaveRequest("003", 8));
        System.out.println("最终结果：" + result3 + "\n");
    }
}

