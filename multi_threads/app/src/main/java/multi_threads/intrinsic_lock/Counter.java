package multi_threads.intrinsic_lock;

public class Counter implements Runnable {

  int sharedRecource = 0;

  public int getShardRecource() {
    return sharedRecource;
  }

  @Override
  public void run() {
    synchronized (this) {
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
    }
  }

  void increase() {
    sharedRecource += 1;
  }

  void decrease() {
    sharedRecource -= 1;
  }
}
