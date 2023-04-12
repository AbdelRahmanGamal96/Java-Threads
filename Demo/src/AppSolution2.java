
class MyRunnableThread implements Runnable {

    public static int myCount = 0;

    public MyRunnableThread() {

    }

    // public MyRunnableThread(String name) {
    // chiledThread = name;
    // }

    public void run() {

        while (MyRunnableThread.myCount < 10) {
            try {
                System.out.println("In $ + John count is " + (++MyRunnableThread.myCount));
                Thread.sleep(700);
            } catch (InterruptedException exc) {
                System.out.println("Exception in thread: " + exc.getMessage());
            }
        }
    }
}

class RunMyThread {
    public static void main(String args[]) {
        System.out.println("Starting Main Thread...");
        MyRunnableThread mrt = new MyRunnableThread();
        Thread thread = new Thread(mrt);
        thread.start();
        while (MyRunnableThread.myCount != 10) {
            try {
                System.out.println("In $ + Smith count is " + (++MyRunnableThread.myCount));
                Thread.sleep(400);
            } catch (InterruptedException exc) {
                System.out.println("Exception in main thread: " + exc.getMessage());
            }
        }
        System.out.println("End of Main Thread !!");
    }
}
