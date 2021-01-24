package chain_of_responsibility_pattern.chain2;

/**
 * @author qulingxiao
 * @className ValidateHandler
 * @description TODO
 * @since 2021/1/23 16:34
 */
public class ValidateHandler extends Handler {
    public void doHandler(Member member) {
        if (member.getLoginName().isEmpty() ||
                member.getLoginPass().isEmpty()) {
            System.out.println("用户名和密码为空");
            return;
        }
        System.out.println("用户名和密码不为空，可以往下执行");
        next.doHandler(member);
    }
}
