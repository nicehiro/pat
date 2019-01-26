package algorithm;

/**
 * 最大子序列求和问题.
 *
 * @author hiro
 */
public class MaxSumSquence {
  /**
   * 穷举遍历.
   *
   * @param a 数组
   * @return 最大值
   */
  public static int maxSum1(int[] a) {
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      for (int j = i; j < a.length; j++) {
        int tempSum = 0;
        for (int k = i; k <= j; k++) {
          tempSum += a[k];
        }
        if (tempSum > maxSum) {
          maxSum = tempSum;
        }
      }
    }
    return maxSum;
  }

  /**
   * 比上一个算法少了一次遍历.
   * 主要是不需要每次对求过一次的结果再求一次.
   *
   * @param a 数组
   * @return 最大值
   */
  public static int maxSum2(int[] a) {
    int maxSum = 0;
    for (int i = 0; i < a.length; i++) {
      int tempSum = 0;
      for (int j = i; j < a.length; j++) {
        tempSum += a[j];
        if (tempSum > maxSum) {
          maxSum = tempSum;
        }
      }
    }
    return maxSum;
  }

  /**
   * 动态规划；最大序列要么在左边，要么在右边，要么是左边的最大加上右边的最大.
   *
   * @param a     数组
   * @param left  左边起点
   * @param right 右边终点
   * @return 最大值
   */
  public static int maxSum3(int[] a, int left, int right) {
    if (left == right) {
      if (a[left] > 0) {
        return a[left];
      } else {
        return 0;
      }
    }

    int center = (left + right) / 2;
    // 左边最大值
    int maxSumLeft = maxSum3(a, left, center);
    // 右边最大值
    int maxSumRight = maxSum3(a, center + 1, right);

    // 左边包括最后一个值的最大值
    int maxLeftBorderSum = 0, leftBorderSum = 0;
    for (int i = center; i > left; i--) {
      leftBorderSum += a[i];
      if (leftBorderSum > maxLeftBorderSum) {
        maxLeftBorderSum = leftBorderSum;
      }
    }

    // 右边包括第一个值的最大值
    int maxRightBorderSum = 0, rightBorderSum = 0;
    for (int i = center + 1; i <= right; i++) {
      rightBorderSum += a[i];
      if (rightBorderSum > maxRightBorderSum) {
        maxRightBorderSum = rightBorderSum;
      }
    }

    return max3(maxSumLeft, maxSumRight, maxLeftBorderSum + maxRightBorderSum);
  }

  /**
   * 联机算法.
   *
   * @param a 数组
   * @return 最大值
   */
  private static int maxSum4(int[] a) {
    int maxSum = 0;
    int tempSum = 0;
    for (int i = 0; i < a.length; i++) {
      tempSum += a[i];
      if (tempSum < 0) {
        tempSum = 0;
      } else if (tempSum > maxSum) {
        maxSum = tempSum;
      }
    }
    return maxSum;
  }

  private static int max3(int a, int b, int c) {
    if (a > b && a > c) {
      return a;
    } else if (b > a && b > c) {
      return b;
    } else {
      return c;
    }
  }
}
