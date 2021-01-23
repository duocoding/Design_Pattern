package chain_of_responsibility_pattern.chain2;

/**
 * @author qulingxiao
 * @className LoginHandler
 * @description TODO
 * @since 2021/1/23 16:37
 */
public class LoginHandler extends Handler {
    public void doHandler(Member member) {
        System.out.println("登录成功！");
        member.setRoleName("管理员");
        next.doHandler(member);
    }
}
