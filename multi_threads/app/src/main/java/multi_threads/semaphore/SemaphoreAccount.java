package multi_threads.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreAccount {

  private int balance = 0;
  Semaphore semaphore;

  public SemaphoreAccount(Semaphore semaphore) {
    this.semaphore = semaphore;
  }

  public void deposit(int money) {
    try {
      semaphore.acquire();

      balance += money;
      System.out.println(
        "[" +
        Thread.currentThread().getName() +
        "] amount : (+)" +
        money +
        " , after deposit -> balance : " +
        balance +
        "\n"
      );

      semaphore.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
      semaphore.release();
    }
  }

  public void withdraw(int money) {
    try {
      semaphore.acquire();

      if ((balance - money) < 0) {
        throw new InterruptedException("Balance is not enough to withdraw");
      }
      balance -= money;
      System.out.println(
        "[" +
        Thread.currentThread().getName() +
        "] amount : (-)" +
        money +
        " , after withdraw -> balance : " +
        balance +
        "\n"
      );

      semaphore.release();
    } catch (InterruptedException e) {
      System.out.println(
        "[" + Thread.currentThread().getName() + "] failed to withdraw"
      );
      e.printStackTrace();
      semaphore.release();
    }
  }

  public void printBalance() {
    System.out.println(
      "[" +
      Thread.currentThread().getName() +
      "] current balance : " +
      balance +
      "\n"
    );
  }
}
