import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Exer14 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int windows = scanner.nextInt();
    int inLine = scanner.nextInt();
    int wait = scanner.nextInt();
    int query = scanner.nextInt();

    Map<Integer, Integer> waitPeople = new HashMap<>();
    for (int i = 1; i <= wait; i++) {
      waitPeople.put(i, scanner.nextInt());
    }
    // 初始化 窗口，排队人数和时间
    List<Windows> windowsList = new ArrayList<>();
    for (int i = 1; i <= windows; i++) {
      Windows windows1 = new Windows(0, 0);
      windowsList.add(windows1);
    }
    Map<Integer, People> servicedPeople = new HashMap<>();
    servicedPeople.put(0, new People(0, 0, false));

    if (inLine != 0) {
      for (int j = 1; j <= wait; j++) {
        // 是否需要移除队列
        boolean isPlan = false;
        for (int i = 0; i < windows; i++) {
          if (windowsList.get(i).number < inLine) {
            isPlan = true;
          }
        }
        if (!isPlan) {
          // 需要移除
          // 将队列中时间最早结束的队列的排队人数-1
          int minTimeWin = 0;
          int minTimeServ = Integer.MAX_VALUE;

          for (int i = 0; i < windows; i++) {
            int temp = windowsList.get(i).peopleList.get(0).time;
            if (temp < minTimeServ) {
              minTimeServ = temp;
              minTimeWin = i;
            }
          }
          windowsList.get(minTimeWin).number--;
          windowsList.get(minTimeWin).peopleList.remove(0);
        }
        // 找队列不满 且 时间最前 的队列
        int minTime = Integer.MAX_VALUE;
        int winNumber = 0;
        for (int i = 0; i < windows; i++) {
          if (windowsList.get(i).number < inLine) {
            // 找最小时间
            if (windowsList.get(i).time < minTime) {
              minTime = windowsList.get(i).time;
              winNumber = i;
            }
          }
        }
        // 如果可以被安排 安排队列
        windowsList.get(winNumber).number++;
        People people = new People(minTime + waitPeople.get(j), winNumber, true);
        windowsList.get(winNumber).peopleList.add(people);
        servicedPeople.put(j, people);
        windowsList.get(winNumber).time = minTime + waitPeople.get(j);
      }
      String res = "";
      for (int i = 0; i < query; i++) {
        int queryId = scanner.nextInt();
        res = res + (mintes2Time(servicedPeople.get(queryId - 1).time, servicedPeople.get(queryId).time) + "\n");
      }
      System.out.println(res.trim());
    } else {
      String res = "";
      for (int i=0; i<query; i++) {
        scanner.nextInt();
        res = res + "Sorry" + "\n";
      }
      System.out.println(res.trim());
    }
  }

  private static String mintes2Time(int startTime, int endTime) {
    int startHour = startTime / 60 + 8;
    int startMintes = startTime % 60;
    if (startHour >= 17 && startMintes >= 0) {
      return "Sorry";
    } else {
      int endHour = endTime / 60 + 8;
      int endMintes = endTime % 60;
      DateFormat dateFormat = new SimpleDateFormat("HH:mm");
      Date date = new Date();
      date.setHours(endHour);
      date.setMinutes(endMintes);
      return dateFormat.format(date);
    }
  }

}

class People {
  int time;
  int windowId;
  boolean isInLine;

  public People(int time, int windowId, boolean isInLine) {
    this.time = time;
    this.windowId = windowId;
    this.isInLine = isInLine;
  }
}

class Windows {
  int number;
  int time;
  List<People> peopleList;

  public Windows(int number, int time) {
    this.number = number;
    this.time = time;
    peopleList = new ArrayList<>();
  }
}
