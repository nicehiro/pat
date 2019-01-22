import java.util.Scanner;

public class Exer3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int cityNumber = scanner.nextInt();
    int roadNumber = scanner.nextInt();
    int startCity = scanner.nextInt();
    int rescueCity = scanner.nextInt();

    int[] citys = new int[cityNumber];
    int[][] roads = new int[cityNumber][cityNumber];
    boolean[] visit = new boolean[cityNumber];
    int[] dist = new int[cityNumber];
    int[] power = new int[cityNumber];
    int[] num = new int[cityNumber];

    for (int i = 0; i < cityNumber; i++) {
      for (int j = 0; j < cityNumber; j++) {
        if (i == j) {
          roads[i][j] = 0;
        } else {
          roads[i][j] = Integer.MAX_VALUE >> 1;
        }
      }
    }

    for (int i = 0; i < cityNumber; i++) {
      citys[i] = scanner.nextInt();
    }

    for (int i = 0; i < roadNumber; i++) {
      int a = scanner.nextInt();
      int b = scanner.nextInt();
      int c = scanner.nextInt();
      roads[a][b] = roads[b][a] = c;
    }

    for (int i = 0; i < cityNumber; i++) {
      visit[i] = false;
      dist[i] = roads[startCity][i];
      if (dist[i] != Integer.MAX_VALUE) {
        power[i] = citys[startCity] + citys[i];
        num[i] = 1;
      }
    }

    dist[startCity] = 0;
    visit[startCity] = true;
    power[startCity] = citys[startCity];
    num[startCity] = 1;
    // 更新 cityNumber-1 次 dist 数组
    for (int i = 1; i < cityNumber; i++) {
      int min = Integer.MAX_VALUE;
      int k = -1;
      // 每次更新先查找最小的dist值
      for (int j = 0; j < cityNumber; j++) {
        if (!visit[j]) {
          if (dist[j] < min) {
            min = dist[j];
            k = j;
          }
        }
      }
      // 标记为访问过
      if (k == -1) {
        break;
      }
      visit[k] = true;

      // 更新 dist 数组
      for (int j = 0; j < cityNumber; j++) {
        int tmp = (roads[k][j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : (min + roads[k][j]));
        if (!visit[j] && (tmp < dist[j])) {
          dist[j] = tmp;
          power[j] = power[k] + citys[j];
          num[j] = num[k];
        } else if (!visit[j] && tmp == dist[j]) {
          num[j] = num[k] + num[j];
          if (power[k] + citys[j] > power[j]) {
            power[j] = power[k] + citys[j];
          }
        }
      }
    }
    System.out.println(num[rescueCity] + " " + power[rescueCity]);
  }
}