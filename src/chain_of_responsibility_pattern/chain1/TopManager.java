package chain_of_responsibility_pattern.chain1;

import java.util.Random;

/**
 * @author qulingxiao
 * @className TopManager
 * @description TODO
 * @since 2021/1/23 16:20
 */
public class TopManager extends AbstractHandler {
    public TopManager(String name) {
        super(name);
    }

    @Override
    public boolean process(LeaveRequest leaveRequest) {
        boolean result = (new Random().nextInt(10)) > 3; // 随机数大于3则为批准，否则不批准
        String log = "总经理<%s> 审批 <%s> 的请假申请，请假天数： <%d> ，审批结果：<%s> ";
        System.out.println(String.format(log, this.name, leaveRequest.getName(), leaveRequest.getNumOfDays(), result == true ? "批准" : "不批准"));

        if (result == false) { // 总经理不批准
            return false;
        }
        return true;    // 总经理最后批准
    }
}