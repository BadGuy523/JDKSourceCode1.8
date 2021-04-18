package test.zjq.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    private static Lock lock = new ReentrantLock();

    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        ConditionDemoWait conditionDemoWait = new ConditionDemoWait(lock, condition);
        ConditionDemoSignal conditionDemoSignal = new ConditionDemoSignal(lock,condition);
        Thread threadWait = new Thread(conditionDemoWait);
        Thread threadSignal = new Thread(conditionDemoSignal);
        threadWait.start();
        Thread.sleep(2000);
        threadSignal.start();
    }
}
