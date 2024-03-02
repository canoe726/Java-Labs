package multi_threads;

import multi_threads.array_thread.BigArrayReadThread;

public class App {

  public static void main(String[] args) {
    BigArrayReadThread test = new BigArrayReadThread();
    test.findIndexByLoop(-99);
  }
}
