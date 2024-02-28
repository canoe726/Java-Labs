package multi_threads.customer_procedure;

public class ConsumerProducerMain {

  final ConsumerProducer cp = new ConsumerProducer();

  public void startThreads() {
    Thread t1 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            cp.produce();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      },
      "Thread1"
    );

    Thread t2 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          try {
            cp.consume();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      },
      "Thread2"
    );

    t1.start();
    t2.start();
  }
}
