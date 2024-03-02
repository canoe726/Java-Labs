package multi_threads.array_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BigArrayReadThread {

  /**
   * int:   4byte
   *
   * 4KB:   1,000
   * 4MB:   1,000,000
   * 160MB: 40,000,000
   * 4GB:   1,000,000,000
   */
  private final int SIZE = 1000000000;
  private final int N_THREADS = 4;
  private int[] bigArray = new int[SIZE];
  private int target_index = -1;

  public BigArrayReadThread() {
    initializeByLoop();
  }

  public void initializeByLoop() {
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < SIZE; i++) {
      bigArray[i] = i;
    }

    int index = (int) (Math.random() * SIZE);
    bigArray[index] = -99;

    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.printf(
      "BigArrayReadThread is initialized by loop while (" +
      estimatedTime +
      " ms)\n"
    );
  }

  public void initializeByThread() {
    long startTime = System.currentTimeMillis();

    ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

    int blockSize = SIZE / N_THREADS;
    for (int i = 0; i < N_THREADS - 1; i++) {
      int start = i * blockSize;
      int end = (i + 1) * blockSize;

      executor.execute(() -> {
        for (int index = start; index < end; index++) {
          bigArray[index] = index;
        }
      });
    }
    executor.shutdown();
    while (!executor.isTerminated()) {}

    int index = (int) (Math.random() * 1) * SIZE;
    bigArray[index] = -99;

    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.printf(
      "BigArrayReadThread is initialized by threads while (" +
      estimatedTime +
      " ms)\n"
    );
  }

  public int findIndexByLoop(int value) {
    int target_index = -1;
    long startTime = System.currentTimeMillis();

    for (int i = 0; i < SIZE; i++) {
      if (bigArray[i] == value) {
        target_index = i;
      }
    }

    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.printf(
      "[findIndexByLoop] is executed while (" + estimatedTime + " ms)\n"
    );
    System.out.println("[findIndexByLoop] index : " + target_index + "\n");

    return target_index;
  }

  public int getTargetIndex() {
    return target_index;
  }

  public int findIndexByThread(int value) {
    long startTime = System.currentTimeMillis();
    ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);

    int blockSize = SIZE / N_THREADS;

    for (int i = 0; i < N_THREADS - 1; i++) {
      int start = i * blockSize;
      int end = (i + 1) * blockSize;

      executor.execute(() -> {
        for (int index = start; index < end; index++) {
          if (bigArray[index] == value) {
            target_index = index;
          }
        }
      });
    }
    executor.shutdown();
    while (!executor.isTerminated()) {}

    // Thread t1 = new Thread(
    //   new Runnable() {
    //     @Override
    //     public void run() {
    //       for (int i = loopSize * 0; i < loopSize * 1; i++) {
    //         if (bigArray[i] == value) {
    //           target_index = i;
    //         }
    //       }
    //     }
    //   }
    // );
    // Thread t2 = new Thread(
    //   new Runnable() {
    //     @Override
    //     public void run() {
    //       for (int i = loopSize * 1; i < loopSize * 2; i++) {
    //         if (bigArray[i] == value) {
    //           target_index = i;
    //         }
    //       }
    //     }
    //   }
    // );
    // Thread t3 = new Thread(
    //   new Runnable() {
    //     @Override
    //     public void run() {
    //       for (int i = loopSize * 2; i < loopSize * 3; i++) {
    //         if (bigArray[i] == value) {
    //           target_index = i;
    //         }
    //       }
    //     }
    //   }
    // );
    // Thread t4 = new Thread(
    //   new Runnable() {
    //     @Override
    //     public void run() {
    //       for (int i = loopSize * 3; i < loopSize * 4; i++) {
    //         if (bigArray[i] == value) {
    //           target_index = i;
    //         }
    //       }
    //     }
    //   }
    // );

    // t1.start();
    // t2.start();
    // t3.start();
    // t4.start();

    // t1.join();
    // t2.join();
    // t3.join();
    // t4.join();

    long estimatedTime = System.currentTimeMillis() - startTime;
    System.out.printf(
      "[findIndexByThread] is executed while (" + estimatedTime + " ms)\n"
    );
    System.out.println("[findIndexByThread] index : " + target_index + "\n");

    return target_index;
  }
}
