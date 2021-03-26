package thread;

public class waitSleep {

    public void test1() throws InterruptedException {
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        thread.start();
        Object o=new Object();

    }
}
