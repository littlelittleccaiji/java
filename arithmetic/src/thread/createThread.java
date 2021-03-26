package thread;

import java.util.Random;
import java.util.concurrent.*;

public class createThread {



    class way1 implements Runnable{
        @Override
        public void run() {
            System.out.println("Runnable thread");
        }
    }

    static class way2 extends Thread{
        @Override
        public void run() {
            System.out.println("extends thread");
        }
    }
    public void test(){
        way1 a=new way1();
        Thread way1Thread=new Thread(a);
        way1Thread.start();
        way2 b=new way2();
        Thread way2Thread=new Thread(b);
        way2Thread.start();
    }
    static class CallableTask1 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

//    public static void main(String[] args) throws ExecutionException, InterruptedException {
        public void testCallable1() throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        // 提交任务，并⽤ Future提交返回结果
        Future<Integer> future = service.submit(new CallableTask1());
        future.get();
        System.out.println(future);
    }

    static class CallableTask2 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return new Random().nextInt();
        }
    }

//   public void testCallable2() throws ExecutionException, InterruptedException {
       public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CallableTask2());
        Thread thread = new Thread(futureTask);
        thread.start();  //开启线程
        Integer result = futureTask.get();   //获取返回值
        System.out.println("result is ****" + result);  //打印
    }
}
