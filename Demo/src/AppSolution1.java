class MyRunnableThread implements Runnable {

    int myCount;
    String threadName;

    MyRunnableThread(String name) {
        myCount = 0;
        threadName = name;
    }

    public void run() {
        System.out.println(threadName + "starting.");
        while (myCount < 10) {
            try {
                Thread.sleep(700);
                System.out.println("In $ + threadName count is " + (myCount));
                myCount++;
            } catch (InterruptedException exc) {
                System.out.println("Exception in thread: ");
            }
        }
    }
}

class AppSolution1 {
    public static void main(String args[]) {
        System.out.println("Starting Main Thread...");
        MyRunnableThread mrt = new MyRunnableThread("Chiled #1");
        Thread newThread = new Thread(mrt);
        newThread.start();
        while (mrt.myCount != 10) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException exc) {
                System.out.println("Exception in main thread: ");
            }
        }
        System.out.println("End of Main Thread!!");
    }
}