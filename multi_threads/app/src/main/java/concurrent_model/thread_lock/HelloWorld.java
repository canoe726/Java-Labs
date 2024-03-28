package concurrent_model.thread_lock;

public class HelloWorld {

  public void helloWorld() throws InterruptedException {
    Thread myThread = new Thread() {
      public void run() {
        System.out.println("Hello from new thread");
      }
    };

    myThread.start();
    // Thread.yield();
    Thread.sleep(1);
    System.out.println("Hello from main thread");
    myThread.join();
  }
}
