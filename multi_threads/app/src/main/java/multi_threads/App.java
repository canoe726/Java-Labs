package multi_threads;

import multi_threads.mutex.Bank;

public class App {

  public static void main(String[] args) {
    Bank bank1 = new Bank("ATM");
    Bank bank2 = new Bank("은행");

    bank1.start();
    bank2.start();
  }
}
