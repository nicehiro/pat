package algorithm;

/**
 * Floyd 算法 多源最短路径.
 *
 * @author hiro
 */
public class Floyd {
  /**
   * floyd 算法求多源最短路径.
   *
   * @param n    顶点集合长度
   * @param edge 边集
   * @return 二维数组 长度集合
   */
  public static int[][] floyd(int n, int[][] edge) {
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          edge[i][j] = Math.min(edge[i][j], edge[i][k] + edge[k][j]);
        }
      }
    }
    return edge;
  }
}
