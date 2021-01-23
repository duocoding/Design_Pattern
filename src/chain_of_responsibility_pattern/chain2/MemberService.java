package chain_of_responsibility_pattern.chain2;

/**
 * @author qulingxiao
 * @className MemberService
 * @description TODO
 * @since 2021/1/23 16:38
 */
public class MemberService {
    public void login(String loginName,String loginPass){
        Handler.Builder builder = new Handler.Builder();
        builder.addHandler(new ValidateHandler())
                .addHandler(new LoginHandler())
                .addHandler(new AuthHandler());
        builder.build().doHandler(new Member(loginName,loginPass));
    }
}
