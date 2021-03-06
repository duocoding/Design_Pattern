## 责任链模式

### 问题描述：以员工请假为例
**一般公司普通员工的请假流程简化如下：**

![alt 如下图](https://user-gold-cdn.xitu.io/2018/10/31/166c90b174855416?imageslim)

普通员工发起一个请假申请，当请假天数小于3天时只需要得到主管批准即可；当请假天数大于3天时，
主管批准后还需要提交给经理审批，经理审批通过，若请假天数大于7天还需要进一步提交给总经理审批。

使用 if-else 来实现这个请假流程的简化代码如下：
```java
public class LeaveApproval {
    public boolean process(String request, int number) {
        boolean result = handleByDirector(request); // 主管处理
        if (result == false) {  // 主管不批准
            return false;
        } else if (number < 3) {    // 主管批准且天数小于 3
            return true;
        }

        result = handleByManager(request); // 准管批准且天数大于等于 3，提交给经理处理
        if (result == false) {   // 经理不批准
            return false;
        } else if (number < 7) { // 经理批准且天数小于 7
            return true;
        }

        result = handleByTopManager(request);   // 经理批准且天数大于等于 7，提交给总经理处理
        if (result == false) { // 总经理不批准
            return false;
        }
        return true;    // 总经理最后批准
    }

    public boolean handleByDirector(String request) {
        // 主管处理该请假申请
    }

    public boolean handleByManager(String request) {
        // 经理处理该请假申请
    }

    public boolean handleByTopManager(String request) {
        // 总经理处理该请假申请
    }
}
```
问题看起来很简单，三下五除二就搞定，但是该方案存在几个问题：
1. LeaveApproval 类比较庞大，各个上级的审批方法都集中在该类中，违反了 ["单一职责原则"](https://zhuanlan.zhihu.com/p/24198903)
，测试和维护难度大

2. 当需要修改该请假流程，譬如增加当天数大于30天时还需提交给董事长处理，
必须修改该类源代码（并重新进行严格地测试），违反了 ["开闭原则"](https://zhuanlan.zhihu.com/p/24269134)

3. 该流程缺乏灵活性，流程确定后不可再修改（除非修改源代码），客户端无法定制流程

#### **使用责任链模式可以解决上述问题。**

**责任链模式**（Chain of Responsibility）是一种行为设计模式， 
允许你将请求沿着处理者链进行发送。 收到请求后， 每个处理者均可对请求进行处理， 
或将其传递给链上的下个处理者， 可以避免请求发送者与处理者耦合在一起，
让多个对象都有可能接收请求，将这些对象连接成一条链，并且沿着这条链传递请求，
直到有对象处理它为止， 如下图所示：

![alt 如下图](https://refactoringguru.cn/images/patterns/content/chain-of-responsibility/chain-of-responsibility-2x.png)

#### 角色
Handler（抽象处理者）：它定义了一个处理请求的接口，一般设计为抽象类，
由于不同的具体处理者处理请求的方式不同，因此在其中定义了抽象请求处理方法。
因为每一个处理者的下家还是一个处理者，因此在抽象处理者中定义了一个抽象处理者类型的对象，
作为其对下家的引用。通过该引用，处理者可以连成一条链。

ConcreteHandler（具体处理者）：它是抽象处理者的子类，可以处理用户请求，
在具体处理者类中实现了抽象处理者中定义的抽象请求处理方法，在处理请求之前需要进行判断，
看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者；
在具体处理者中可以访问链中下一个对象，以便请求的转发。

###### **类图如下所示**：
![alt 如下图](https://user-gold-cdn.xitu.io/2018/10/31/166c90b265849954?imageslim)

### 实现方式

#### 按照当前节点的行为分为两种方式
常见的责任链流程如下：

![alt 如下图](https://pic3.zhimg.com/80/v2-07b6b9ee4ea60e64cf7acaa31e4f06b6_1440w.jpg)
##### 1.节点传递方式
节点传递方式也就是，责任链中当前节点处理完成之后，自己传递给下一个处理节点继续处理。 
```java
public interface Handler {
    default boolean match(String msg) {
        return true;
    }
    void process(String msg);
}

public abstract class AbstractHandler implements Handler {
    private Handler next;

    public AbstractHandler setNextHandler(Handler next) {
        this.next = next;
        return this;
    }

    @Override
    public void process(String msg) {
        doProcess(msg);

        if (next != null) {
            next.process(msg);
        }
    }

    protected abstract void doProcess(String msg);
}

// 具体的责任链处理器
public class Handler1 extends AbstractHandler {
    @Override
    public void doProcess(String msg) {
        System.out.println("[Handler1] process " + msg);
    }
}
public class Handler2 extends AbstractHandler {
    @Override
    protected void doProcess(String msg) {
        System.out.println("[Handler2] process " + msg);
    }
}
public class Handler3 extends AbstractHandler {
    @Override
    protected void doProcess(String msg) {
        System.out.println("[Handler3] process " + msg);
    }
}
```
![alt 如图所示](https://pic1.zhimg.com/80/v2-3921f765ba862e9ab3cf9dffc33e7f58_1440w.jpg)

##### 2.统一传递方式
统一传递方式也就是，不由责任链中处理节点传递给下一个节点，而是由统一的传递逻辑进行传递。
```java
public class HandlerWrap {
    private List<Handler> handlerList = new ArrayList<>();

    public HandlerWrap() {
        handlerList.add(new Handler1());
        handlerList.add(new Handler2());
        handlerList.add(new Handler3());
    }

    public void process(String msg) {
        for (Handler handler : handlerList) {
            handler.process(msg);
        }
    }
}

public class Handler1 implements Handler {
    @Override
    public void process(String msg) {
        System.out.println("[Handler1] process " + msg);
    }
}
public class Handler2 implements Handler {
    @Override
    public void process(String msg) {
        System.out.println("[Handler2] process " + msg);
    }
}
public class Handler3 implements Handler {
    @Override
    public void process(String msg) {
        System.out.println("[Handler3] process " + msg);
    }
}
```
![alt ](https://pic1.zhimg.com/80/v2-e296c97798ff86c893251b6d22ae571c_1440w.jpg)
##### 两种实现方式比较
上述两种实现方式差别就是谁来进行下一个节点的传递工作，节点传递方式 是责任链中当前处理节点处理完成之后，自己传递给下一个节点；统一传递方式 是在统一的地方进行传递工作，减轻处理节点的“负担”。

二者本质上是一样的，不过前一种实现方式初始化成本较高，还要注意处理节点的前后顺序，这种调整一个节点的位置时特别要注意前后节点的关系，否则处理链顺序就错乱了。
##### 抽象出来具体的步骤如下：

1. 声明处理者接口并描述请求处理方法。

       确定客户端如何将请求数据传递给方法。 最灵活的方式是将请求转换为对象， 然后将其以参数的形式传递给处理函数。

2. 为了在具体处理者中消除重复的样本代码， 你可以根据处理者接口创建抽象处理者基类。

          1. 该类需要有一个成员变量来存储指向链上下个处理者的引用。 你可以将其设置为不可变类。 但如果你打算在运行时对链进行改变，
       则需要定义一个设定方法来修改引用成员变量的值。
          2. 为了使用方便， 你还可以实现处理方法的默认行为。 如果还有剩余对象， 该方法会将请求传递给下个对象。 
       具体处理者还能够通过调用父对象的方法来使用这一行为。

3. 依次创建具体处理者子类并实现其处理方法。 每个处理者在接收到请求后都必须做出两个决定：

       1. 是否自行处理这个请求。
       2. 是否将该请求沿着链进行传递。
4. 客户端可以自行组装链， 或者从其他对象处获得预先组装好的链。 在后一种情况下， 你必须实现工厂类以根据配置或环境设置来创建链。

5. 客户端可以触发链中的任意处理者， 而不仅仅是第一个。 请求将通过链进行传递， 直至某个处理者拒绝继续传递， 或者请求到达链尾。

6. 由于链的动态性， 客户端需要准备好处理以下情况：

       1. 链中可能只有单个链接。
       2. 部分请求可能无法到达链尾。
       3. 其他请求可能直到链尾都未被处理。
       
### 纯与不纯的责任链模式

#### 纯的责任链模式：

* 一个具体处理者对象只能在两个行为中选择一个：要么承担全部责任，要么将责任推给下家，
不允许出现某一个具体处理者对象在承担了一部分或全部责任后
又将责任向下传递的情况
* 一个请求必须被某一个处理者对象所接收，不能出现某个请求未被任何一个处理者对象处理的情况

#### 不纯的责任链模式：

* 允许某个请求被一个具体处理者部分处理后再向下传递
* 或者一个具体处理者处理完某请求后其后继处理者可以继续处理该请求
* 而且一个请求可以最终不被任何处理者对象所接收

### 责任链模式的应用场景
在日常生活中责任链梩式还是比较常见的，我们平时工作处理一些事务，往往是各部门协同合作的 完成一个任务。
而每个部门都有各自的职责，因此，很多时候事谓完成一半，便会转交给下一个部门， 
直到所有部门都过一遍之后事谓才能完成。还有我们平时俗话说的过五关、斩六将其实也是一种责任链。

#### 适用于以下应用场景 ：

1 、多个对象可以处理同一请求，但具体由哪个对象处理则在运行时动态决定；

2、在不明确指定接收者的情况下，向多个对象中的一个提交一个请求；

3、可动态指定一组对象处理请求，客户端可以动态创建职责链来处理请求，还可以改变链中处理者之间的先后次序

#### 责任链模式的典型应用

* [javax.servlet.Filter#doFilter()](http://docs.oracle.com/javaee/7/api/javax/servlet/Filter.html#doFilter-javax.servlet.ServletRequest-javax.servlet.ServletResponse-javax.servlet.FilterChain-)
* [java.util.logging.Logger#log()](http://docs.oracle.com/javase/8/docs/api/java/util/logging/Logger.html#log-java.util.logging.Level-java.lang.String-)
* Netty 中的 Pipeline 和 ChannelHandler 通过责任链设计模式来组织代码逻辑
* Spring Security 使用责任链模式，可以动态地添加或删除责任（处理 request 请求）
* Spring AOP 通过责任链模式来管理 Advisor
* Dubbo Filter 过滤器链也是用了责任链模式（链表），可以对方法调用做一些过滤处理，譬如超时(TimeoutFilter)，异常(ExceptionFilter)，Token(TokenFilter)等
* Mybatis 中的 Plugin 机制使用了责任链模式，配置各种官方或者自定义的 Plugin，与 Filter 类似，可以在执行 Sql 语句的时候做一些操作

### 责任链模式的优缺点
#### 优点：
​ 1、将请求与处理解耦；

​ 2、请求处理者(节点对象)只需关注自己感兴趣的请求进行处理即可，对于不感兴趣的请求，直接转 发给下一级节点对象;

​ 3、 具备链式传递处理请求功能，请求发送者无需知晓链路结构，只需等待请求处理结果；

​ 4、 链路结构灵活，可以通过改变链路结构动态地新增或删减责任；

5、 易于扩展新的请求处理类（节点），符合开闭原则。

#### 缺点：

​ 1、 责任链太长或者处理时间过长，会影响整体性能

​ 2、 如果节点对象存在循环引用时，会造成死循环，导致系统崩溃；



