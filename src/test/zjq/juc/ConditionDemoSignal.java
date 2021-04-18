package test.zjq.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ConditionDemoSignal implements Runnable {
    private Lock lock;
    private Condition condition;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin - ConditionDemoSignal");
        try {
            lock.lock();
            // 唤醒阻塞线程
            condition.signal();
            System.out.println("end - ConditionDemoSignal");
        } finally {
            lock.unlock();
        }
    }
}
