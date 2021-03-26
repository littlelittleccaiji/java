package thread;

public class StopThread implements Runnable{

    @Override
    public void run() {
        int count = 0;
        Thread sonThread=new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println("sonThread");
                }
            }
        });
        sonThread.start();
        while (!Thread.currentThread().isInterrupted() && count < 1000) {
            System.out.println(0+Thread.currentThread().getName());
            System.out.println("count = " + count++);
        }
    }

    /**
     * 可以看到每次运行的结果都是不一样的，线程每次运行都会提前判断线程
     * 的状态
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new StopThread());
        System.out.println(1+thread1.getName());
        thread1.start();
        System.out.println(2+thread1.getName());
        Thread.sleep(50000);
        /**
         * sleep()的作用是通知cpu在未来的多少毫秒内我不参与CPU竞争，Resume则是通知
         * 恢复cpu的竞争但是不一定会马上获得cpu资源。
         * Thread.Sleep(0)的作用，就是“触发操作系统立刻重新进行一次CPU竞争”。
         * 竞争的结果也许是当前线程仍然获得CPU控制权，也许会换成别的线程获得CPU控制权。
         * 这也是我们在大循环里面经常会写一句Thread.Sleep(0) ，因为这样就给了其他线程比如Paint线程获得CPU控制权的权力
         *
         */
        System.out.println(3+thread1.getName());
        thread1.interrupt();
        System.out.println(4+thread1.getName());
    }
}
