package test.zjq.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    /** 悲观锁 **/
    //synchronized
    public synchronized void test() {
        // 操作同步资源
    }

    //ReentrantLock
    private final ReentrantLock lock = new ReentrantLock(); // 需要保证多个线程使用同一个锁
    public void testLock() {
        lock.lock();
        // 操作同步资源
        lock.unlock();
    }





    public static void main(String[] args) {


        /** 乐观锁 **/
        AtomicInteger atomicInteger = new AtomicInteger(); // 需要保证多个线程使用统一个AtomicInteger
        atomicInteger.incrementAndGet(); // 自增1

        /** 公平锁与非公平锁-ReentrantLock **/
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        reentrantLock.unlock();

        LockTest lockTest = new LockTest();
        lockTest.test();
        lockTest.testLock();
    }
}
