import java.util.Scanner;

/**
 * 求一个数列的最大子序列.
 * 算法思想：如果tempSum<0，将tempSum更新为0，tempLeft设为i+1；如果tempSum>0，更新sum、left、right
 */
public class Exer7 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int[] numbers = new int[num];
    int sum = -1;
    int tempSum = 0;
    int left = 0;
    int right = num - 1;
    int tempIndex = 0;
    for (int i = 0; i < num; i++) {
      int temp = scanner.nextInt();
      numbers[i] = temp;
      tempSum += temp;
      if (tempSum < 0) {
        tempSum = 0;
        tempIndex = i + 1;
      } else if (tempSum > sum) {
        sum = tempSum;
        left = tempIndex;
        right = i;
      }
    }
    if (sum < 0) {
      sum = 0;
    }
    System.out.println(sum + " " + numbers[left] + " " + numbers[right]);
  }
}
