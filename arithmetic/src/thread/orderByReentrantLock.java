package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class orderByReentrantLock {
    private int signal;// 还是需要通过信号量控制abc的输出顺序

    Lock lock = new ReentrantLock(); // 只有一个锁
    Condition a = lock.newCondition();// 多个condition
    Condition b = lock.newCondition();
    Condition c = lock.newCondition();

    public void a() {// 去掉了synchronized，取而代之的是reentrantlock的lock和unlock。
        lock.lock();
        while (signal != 0) {
            try {
                a.await();// 释放cpu的执行资格和执行权，同时释放锁
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal++;
        b.signal();// 这里只唤醒了b
        lock.unlock();
    }
    public void b() {
        lock.lock();
        while (signal != 1) {
            try {
                b.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal++;
        c.signal();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        while (signal != 2) {
            try {
                c.await();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        a.signal();
        lock.unlock();
    }

    public static void main(String[] args) {
        orderByReentrantLock e = new orderByReentrantLock();
        A a1 = new A(e);
        A a2 = new A(e);
        A a3 = new A(e);
        B b1 = new B(e);
        B b2 = new B(e);
        B b3 = new B(e);
        C c1 = new C(e);
        C c2 = new C(e);
        C c3 = new C(e);
        new Thread(a1).start();
        new Thread(a2).start();
        new Thread(a3).start();
        new Thread(b1).start();
        new Thread(b2).start();
        new Thread(b3).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();

    }
}

class A implements Runnable {
    private orderByReentrantLock e;
    public A(orderByReentrantLock e) {
        this.e = e;
    }
    @Override
    public void run() {
        while (true) {
            e.a();
        }
    }
}
class B implements Runnable {
    private orderByReentrantLock e;
    public B(orderByReentrantLock e) {
        this.e = e;
    }
    @Override
    public void run() {
        while (true) {
            e.b();
        }
    }
}
class C implements Runnable {
    private orderByReentrantLock e;
    public C(orderByReentrantLock e) {
        this.e = e;
    }
    @Override
    public void run() {
        while (true) {
            e.c();
        }
}
}
