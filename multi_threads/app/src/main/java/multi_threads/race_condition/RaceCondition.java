package multi_threads.race_condition;

public class RaceCondition {

  int sharedRecource = 0;

  public int getShardRecource() {
    return sharedRecource;
  }

  public void startTwoThreads() {
    Thread t1 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          sharedRecource += 1;
        }
      }
    );
    t1.start();

    Thread t2 = new Thread(
      new Runnable() {
        @Override
        public void run() {
          sharedRecource -= 1;
        }
      }
    );
    t2.start();
  }
}
/**
 * TODO Example
 * 
    RaceCondition raceCondition = new RaceCondition();
    raceCondition.startTwoThreads();
    System.out.println(raceCondition.getShardRecource());
 */
