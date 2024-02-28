package multi_threads.explicit_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteLockCounter {

  int sharedRecource = 0;
  private ReentrantReadWriteLock mLock = new ReentrantReadWriteLock();

  public int getShardRecource() {
    mLock.readLock().lock();

    try {
      System.out.println(
        "[" +
        Thread.currentThread().getName() +
        "] sharedRecource : " +
        sharedRecource
      );

      return sharedRecource;
    } finally {
      mLock.readLock().unlock();
    }
  }

  public void increase() {
    mLock.writeLock().lock();
    System.out.println("Increase");

    try {
      sharedRecource += 1;
    } finally {
      mLock.writeLock().unlock();
    }
  }

  public void decrease() {
    mLock.writeLock().lock();
    System.out.println("Decrease");

    try {
      sharedRecource -= 1;
    } finally {
      mLock.writeLock().unlock();
    }
  }
}
