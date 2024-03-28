package multi_threads;

import concurrent_model.thread_lock.HelloWorld;

public class App {

  public static void main(String[] args) throws InterruptedException {
    HelloWorld helloWorld = new HelloWorld();
    helloWorld.helloWorld();
  }
}
