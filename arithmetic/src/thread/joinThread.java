package thread;

public class joinThread implements Runnable {

    static final Object a=1;

    public static void main(String[] sure) throws InterruptedException {
        Thread t = new Thread(new joinThread());
        long start = System.currentTimeMillis();
        t.start();
        t.join(1000);//等待线程t 1000毫秒
        System.out.println(System.currentTimeMillis()-start);//打印出时间间隔
        System.out.println("Main finished");//打印主线程结束
    }

    @Override
    public void run() {
        //注释掉synchronized
         synchronized (Thread.currentThread()) {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(1000);//睡眠5秒，循环是为了方便输出信息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("睡眠" + i);
        }
        System.out.println("TestJoin finished");//t线程结束
    }
    }

}
