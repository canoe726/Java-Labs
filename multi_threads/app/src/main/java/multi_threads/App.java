package multi_threads;

import multi_threads.intrinsic_lock.Synchronized;

public class App {

  public static void main(String[] args) {
    Synchronized test = new Synchronized();
    test.startThreads();
  }
}
