import java.util.*;

/**
 * 此方法的后两个测试点没有通过.
 * 超时
 */
public class Exer13 {
  Set<Integer> citys;
  Set<Integer> visited;
  // 记录这条道路是否通
  boolean[][] roads;

  Exer13(Map<Integer, Integer> roadMap, int cityNumber) {
    this.roads = new boolean[cityNumber + 1][cityNumber + 1];
    for (Map.Entry<Integer, Integer> entry : roadMap.entrySet()) {
      roads[entry.getKey()][entry.getValue()] = true;
      roads[entry.getValue()][entry.getKey()] = true;
    }
    citys = new HashSet<>();
    visited = new HashSet<>();
    for (int i = 1; i <= cityNumber; i++) {
      citys.add(i);
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cityNumber = scanner.nextInt();
    int roadsNumber = scanner.nextInt();
    int concernNumber = scanner.nextInt();

    // 记录这个城市是否可以到达
    IdentityHashMap<Integer, Integer> roadMap = new IdentityHashMap<>();
    for (int i = 1; i <= roadsNumber; i++) {
      int city1 = scanner.nextInt();
      int city2 = scanner.nextInt();
      roadMap.put(new Integer(city1), new Integer(city2));
    }

    int[] repair = new int[concernNumber];
    for (int i = 0; i < concernNumber; i++) {
      int enemy = scanner.nextInt();
      Exer13 exer13 = new Exer13(roadMap, cityNumber);
      exer13.citys.remove(enemy);
      for (int j = 1; j <= cityNumber; j++) {
        exer13.roads[j][enemy] = false;
        exer13.roads[enemy][j] = false;
      }
      // 找非连通子图的个数
      repair[i] = exer13.findChildGra(enemy) - 1;
    }
    String res = "";
    for (int i = 0; i < repair.length - 1; i++) {
      res += repair[i] + "\n";
    }
    res += repair[repair.length-1];
    System.out.println(res);
  }

  private int findChildGra(int enemy) {
    int times = 0;
    for (int i = 1; i <= citys.size() + 1; i++) {
      if (i != enemy && !visited.contains(i)) {
        visited.add(i);
        dfs(i, citys.size() + 1);
        times += 1;
      }
    }
    return times;
  }

  private void dfs(int start, int cityNumber) {
    for (int i = 1; i <= cityNumber; i++) {
      if (roads[start][i] && start != i && !visited.contains(i)) {
        visited.add(i);
        dfs(i, cityNumber);
      }
    }
  }
}
