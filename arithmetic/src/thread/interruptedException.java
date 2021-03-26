package thread;

public class interruptedException {
    public static void main(String[] args) {
        Thread wang=new Thread() {
            public void run() {
                System.out.println("呼叫老王中，等待老王接听，嘟嘟嘟。。。。");
                try {
                    Thread.sleep(10000);//设置阻塞指定的10000毫秒
                } catch (InterruptedException e) {
                    System.out.println("中断与老王的连线。。。。。"+e.getMessage());
                }
                System.out.println("结束");
            }
        };
        Thread chen=new Thread() {
            public void run() {
                System.out.println("在忙");
                for(int i=0;i<6;i++) {//循环6次
                    System.out.println("忙个锤子");
                    try {
                        Thread.sleep(1000);//设置阻塞指定的1000毫秒
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("忙完了!");
                try{
                    wang.interrupt();//此时wang还在阻塞中，我们直接将其中断线程的睡眠阻塞
                    }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        };

        chen.start();//启动线程要调用start
        wang.start();//启动线程要调用start
    }

    public static void main1(String[] args) {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println(111);
                }
            }
        });
        thread.start();
        System.out.println(1111);
        thread.interrupt();
        };

}
