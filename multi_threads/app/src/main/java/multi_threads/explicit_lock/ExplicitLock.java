package multi_threads.explicit_lock;

public class ExplicitLock {

  public void startLockThreads() {
    LockCounter counter = new LockCounter();

    Thread t1 = new Thread(counter, "Thread1");
    Thread t2 = new Thread(counter, "Thread2");
    Thread t3 = new Thread(counter, "Thread3");

    t1.start();
    t2.start();
    t3.start();
  }

  public void startWriteThreads() {
    WriteLockCounter writeLockCounter = new WriteLockCounter();

    Thread t1 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          writeLockCounter.increase();
          writeLockCounter.getShardRecource();
        }
      },
      "Thread1"
    );
    Thread t2 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          writeLockCounter.getShardRecource();
        }
      },
      "Thread2"
    );
    Thread t3 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          writeLockCounter.decrease();
          writeLockCounter.getShardRecource();
        }
      },
      "Thread3"
    );
    Thread t4 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          writeLockCounter.getShardRecource();
        }
      },
      "Thread3"
    );

    t1.start();
    t2.start();
    t3.start();
    t4.start();
  }
}
