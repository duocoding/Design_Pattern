package observer_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Subject
 * @Description TODO
 * @Author qulingxiao
 * @Date 2020/6/25 15:55
 * @Version 1.0
 */
public abstract class Subject {

    private List<Observer> lists = new ArrayList<Observer>();

    public void attach (Observer observer) {
        lists.add(observer);
        System.out.println("Attached an observer");
    }

    public void detach (Observer observer) {
        lists.remove(observer);
    }

    public void notifyObserver(OneSubject oneSubject) {
        for(Observer observer : lists) {
            observer.update(this);
        }
    }
}
