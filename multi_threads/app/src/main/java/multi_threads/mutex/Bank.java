package multi_threads.mutex;

public class Bank extends Thread {

  static Account obj = new Account();

  public Bank(String name) {
    super(name);
  }

  public void run() {
    while (true) {
      synchronized (obj) {
        int money = (int) (Math.random() * 1 + 3) * 100;

        if (obj.balance >= money) {
          System.out.println(getName() + " balance : " + obj.balance);
          System.out.println(getName() + " withdraw : -" + money);
          obj.withdraw(money);
          System.out.println(getName() + " remains : " + obj.balance + "\n");
        } else {
          System.out.println(getName() + " try withdraw : -" + money + "\n");
          break;
        }
      }
    }
  }
}
