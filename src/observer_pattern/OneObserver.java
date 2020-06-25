package observer_pattern;

/**
 * @ClassName OneObserver
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/6/25 16:03
 * @Version 1.0
 */
public class OneObserver implements Observer{

    private String observerStatus;

    @Override
    public void update(Subject subject) {
        observerStatus = ((OneSubject)subject).getStatus();
        System.out.println("观察者状态为："+observerStatus);
    }
}
