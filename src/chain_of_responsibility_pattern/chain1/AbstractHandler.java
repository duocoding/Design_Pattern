package chain_of_responsibility_pattern.chain1;

/**
 * @author qulingxiao
 * @className AbstractHandler
 * @description TODO
 * @since 2021/1/23 16:15
 */
public abstract class AbstractHandler {
    protected String name; // 处理者姓名
    protected AbstractHandler nextHandler;  // 下一个处理者

    public AbstractHandler(String name) {
        this.name = name;
    }

    public AbstractHandler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean process(LeaveRequest leaveRequest); // 处理请假
}
