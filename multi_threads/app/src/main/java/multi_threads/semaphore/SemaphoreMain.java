package multi_threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreMain {

  public void startThreads() {
    Semaphore semaphore = new Semaphore(1, true);
    SemaphoreAccount account = new SemaphoreAccount(semaphore);
    account.printBalance();

    Thread thread1 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 6; i++) {
            int money = (int) (Math.random() * 1 + 5) * 100;

            account.deposit(money);
          }
        }
      },
      "Thread1"
    );
    Thread thread2 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 3; i++) {
            int money = (int) (Math.random() * 1 + 5) * 100;

            account.withdraw(money);
          }
        }
      },
      "Thread2"
    );
    Thread thread3 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          for (int i = 0; i < 10; i++) {
            int money = (int) (Math.random() * 1 + 2) * 100;

            if (i % 2 == 0) {
              account.deposit(money);
            } else {
              account.withdraw((int) (money * 0.8));
            }
          }
        }
      },
      "Thread3"
    );

    thread1.start();
    thread2.start();
    thread3.start();

    try {
      thread1.join();
      thread2.join();
      thread3.join();

      account.printBalance();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
