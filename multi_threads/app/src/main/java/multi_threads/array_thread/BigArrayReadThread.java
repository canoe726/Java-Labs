package multi_threads.array_thread;

import java.util.ArrayList;

public class BigArrayReadThread {

  private ArrayList<Integer> bigArray = new ArrayList<Integer>();
  private final int SIZE = 50000000;

  public BigArrayReadThread() {
    for (int i = 0; i < SIZE; i++) {
      this.bigArray.add(i);
    }

    int index = (int) (Math.random() * 10) * SIZE;
    this.bigArray.set(index, -99);
  }

  public int findIndexByValue(int value) {
    int index = -1;

    Thread t1 = new Thread(
      new Runnable() {
        @Override
        public void run() {}
      }
    );

    t1.start();

    return index;
  }
}
