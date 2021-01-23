package chain_of_responsibility_pattern.chain1;

/**
 * @author qulingxiao
 * @className Handle01
 * @description TODO
 * @since 2021/1/23 15:57
 */

public class Handle01 {

    public boolean process(String request, int number) {
        boolean result = handleByDirector(request); // 主管处理
        if (result == false) {  // 主管不批准
            System.out.println("主管不批准");
            return false;
        } else if (number < 3) {    // 主管批准且天数小于 3
            System.out.println("主管批准");
            return true;
        }

        result = handleByManager(request); // 准管批准且天数大于等于 3，提交给经理处理
        if (result == false) {   // 经理不批准
            System.out.println("经理不批准");
            return false;
        } else if (number < 7) { // 经理批准且天数小于 7
            System.out.println("经理批准");
            return true;
        }

        result = handleByTopManager(request);   // 经理批准且天数大于等于 7，提交给总经理处理
        if (result == false) { // 总经理不批准
            System.out.println("总经理不批准");
            return false;
        }
        System.out.println("总经理批准");
        return true;    // 总经理最后批准
    }

    public boolean handleByDirector(String request) {
//        System.out.println("主管处理该请假申请");
        return request == null ? false : true;
    }

    public boolean handleByManager(String request) {
//        System.out.println("经理处理该请假申请");
        return true;
    }

    public boolean handleByTopManager(String request) {
//        System.out.println("总经理处理该请假申请");
        return true;
    }

    public static void main(String[] args) {
        new Handle01().process("null", 8);
    }

}
