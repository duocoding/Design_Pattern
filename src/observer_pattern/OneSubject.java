package observer_pattern;

/**
 * @ClassName OneSubject
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/6/25 16:06
 * @Version 1.0
 */
public class OneSubject extends Subject{

    private String status;

    public String getStatus () {
        return status;
    }

    public void changeStatus (String newStatus) {
        status = newStatus;
        System.out.println("主题状态为：" + status);
        this.notifyObserver(this);
    }
}
