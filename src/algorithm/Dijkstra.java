package algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Dijkstra 单源最短路径.
 * 给定起点，求到其他各点的最短路径。
 *
 * 算法思想：维护一个dist数组，每次遍历更新dist数组
 * 如何更新：每次取dist中最小的元素，如果过该点到达其他定点的元素比原来的dist小，那么更新
 * 如何改进：取最小值的方法可以使用最小堆
 */
public class Dijkstra {
  /**
   * 求定点s到其他vdex中元素的最短路径.
   * @param s 起始点
   * @param vdex 顶点集合
   * @param edge 边集合
   */
  public static int[] dijkstra(int s, int[] vdex, int[][] edge) {
    int[] dist = new int[vdex.length];
    Set<Integer> visited = new HashSet<>(vdex.length);
    visited.add(s);
    // 初始化dist
    for (int i=0; i<vdex.length; i++) {
      dist[i] = edge[s][i];
    }

    while (visited.size() < vdex.length) {
      // 找dist中的最小值
      int min = Integer.MAX_VALUE;
      int position = -1;
      for (int i=0; i<vdex.length; i++) {
        if (!visited.contains(i) && dist[i] < min) {
          min = dist[i];
          position = i;
        }
      }
      // 更新dist
      if (position == -1) {
        break;
      }
      visited.add(position);
      for (int i=0; i<vdex.length; i++) {
        if (!visited.contains(i)) {
          // 取最小的值
          dist[i] = Math.min(dist[i], dist[position] + edge[position][i]);
        }
      }
    }
    return dist;
  }
}
