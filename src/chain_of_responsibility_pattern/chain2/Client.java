package chain_of_responsibility_pattern.chain2;

/**
 * @author qulingxiao
 * @className client
 * @description TODO
 * @since 2021/1/23 16:43
 */
public class Client {
    public static void main(String[] args) {
        MemberService memberService = new MemberService();
        memberService.login("","666");
    }
}
