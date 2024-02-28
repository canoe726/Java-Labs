package multi_threads.explicit_lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockCounter implements Runnable {

  int sharedRecource = 0;
  private ReentrantLock mLock = new ReentrantLock();

  public int getShardRecource() {
    return sharedRecource;
  }

  @Override
  public void run() {
    mLock.lock();

    try {
      increase();
      System.out.printf(
        "[" +
        Thread.currentThread().getName() +
        "] increase : " +
        getShardRecource()
      );
      System.out.println();

      decrease();
      System.out.printf(
        "[" +
        Thread.currentThread().getName() +
        "] decrease : " +
        getShardRecource()
      );
      System.out.println();
      System.out.println();
    } finally {
      mLock.unlock();
    }
  }

  public void increase() {
    sharedRecource += 1;
  }

  public void decrease() {
    sharedRecource -= 1;
  }
}
