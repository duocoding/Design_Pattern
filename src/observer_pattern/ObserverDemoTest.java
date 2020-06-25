package observer_pattern;

/**
 * @ClassName ObserverDemoTest
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/6/25 16:13
 * @Version 1.0
 */
public class ObserverDemoTest {

    public static void main(String[] args) {

        OneSubject subject = new OneSubject();

        OneObserver observer = new OneObserver();

        subject.attach(observer);

        subject.changeStatus("new status");
    }
}
