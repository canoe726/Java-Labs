package multi_threads;

import multi_threads.customer_procedure.ConsumerProducerMain;

public class App {

  public static void main(String[] args) {
    ConsumerProducerMain test = new ConsumerProducerMain();
    test.startThreads();
  }
}
