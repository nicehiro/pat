import java.util.*;

/**
 * PAT 后两个测试超时.
 * 1. 尽量多使用数组这种数据结构
 * 2. 优化的地方在程序中标出了
 */
public class Exer12 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num1 = scanner.nextInt();
    int num2 = scanner.nextInt();

    List<Grace> graceList = new ArrayList<>();
    String[] ids = new String[num2];
    for (int i = 0; i < num1; i++) {
      String id = scanner.next();
      Grace grace = new Grace(id,
          scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
      graceList.add(grace);
    }

    /**
     * 此处程序丑陋.
     */
    for (int i = 0; i < 4; i++) {
      graceList = rankGrace(graceList, i);
    }


    for (int i=0; i<num2; i++) {
      ids[i] = scanner.next();
    }
    // 找排名最好的；如果有重复的，按顺序输出
    // 此处程序可以优化，不应该对每个数都进行一次遍历操作
    for (int i = 0; i < num2; i++) {
      String id = ids[i];
      boolean flag = false;
      for (int j = 0; j < graceList.size(); j++) {
        if (graceList.get(j).id.equals(id)) {
          if (graceList.get(j).ranks[0] <= graceList.get(j).ranks[1] &&
              graceList.get(j).ranks[0] <= graceList.get(j).ranks[2] &&
              graceList.get(j).ranks[0] <= graceList.get(j).ranks[3]) {
            System.out.println(graceList.get(j).ranks[0] + " " + "A");
          } else if (graceList.get(j).ranks[1] <= graceList.get(j).ranks[0] &&
              graceList.get(j).ranks[1] <= graceList.get(j).ranks[2] &&
              graceList.get(j).ranks[1] <= graceList.get(j).ranks[3]) {
            System.out.println(graceList.get(j).ranks[1] + " " + "C");
          } else if (graceList.get(j).ranks[2] <= graceList.get(j).ranks[0] &&
              graceList.get(j).ranks[2] <= graceList.get(j).ranks[1] &&
              graceList.get(j).ranks[2] <= graceList.get(j).ranks[3]) {
            System.out.println(graceList.get(j).ranks[2] + " " + "M");
          } else {
            System.out.println(graceList.get(j).ranks[3] + " " + "E");
          }
          flag = true;
        }
      }
      if (!flag) {
        System.out.println("N/A");
      }
    }

  }

  private static List<Grace> rankGrace(List<Grace> graceList, int flag) {
    Collections.sort(graceList, new Comparator<Grace>() {
      @Override
      public int compare(Grace o1, Grace o2) {
        return Integer.compare(o2.scores[flag], o1.scores[flag]);
      }
    });

    graceList.get(0).ranks[flag] = 1;
    for (int i = 1; i < graceList.size(); i++) {
      graceList.get(i).ranks[flag] = i + 1;
      if (graceList.get(i).scores[flag] == graceList.get(i - 1).scores[flag]) {
        graceList.get(i).ranks[flag] = graceList.get(i - 1).ranks[flag];
      }
    }
    return graceList;
  }
}

class Grace {
  String id;
  int[] scores = new int[4];

  int[] ranks = new int[4];

  Grace(String id, int cProgram, int math, int english) {
    this.id = id;
    this.scores[1] = cProgram;
    this.scores[2] = math;
    this.scores[3] = english;
    this.scores[0] = (cProgram + math + english) / 3;
  }
}
