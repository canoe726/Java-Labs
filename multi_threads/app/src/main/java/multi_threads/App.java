package multi_threads;

import multi_threads.explicit_lock.ExplicitLock;

public class App {

  public static void main(String[] args) {
    ExplicitLock test = new ExplicitLock();
    test.startWriteThreads();
  }
}
