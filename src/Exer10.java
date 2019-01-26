import java.util.Scanner;

/**
 * 需要注意的地方：
 * 1. radix 的范围不是 2-36；而是 2-无穷大 特例：100 10 1 10 => 100
 * 2. 查找超时 使用二分法而不是迭代查找
 * 3. Integer.parseInt(String, int) 转换的进制有限，需要自己重新写一个方法
 * 4. 二分查找时候的上下限 下限：数字里面的最大值 上限：这个数，看上面1的特例
 */
public class Exer10 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str1 = scanner.next();
    String str2 = scanner.next();
    long tag = scanner.nextLong();
    int tagRedix = scanner.nextInt();
    long num1 = 0;
    long num2 = 0;
    String result = "";
    if (tag == 1) {
      num1 = parseString2Decimal(str1, tagRedix);
      result = findResult(str2, num1);
    } else {
      num2 = parseString2Decimal(str2, tagRedix);
      result = findResult(str1, num2);
    }
    System.out.println(result);
  }

  private static long parseString2Decimal(String str, long redix) {
    char[] nums = str.toCharArray();
    long result = 0;
    for (int i=0; i<nums.length; i++) {
      if (nums[i] <= '9' && nums[i] >= '0') {
        result = (long) (result + (nums[i] - '0') * (Math.pow(redix, nums.length - i - 1)));
      } else {
        result = (long) (result + (nums[i] - 'a' + 10) * (Math.pow(redix, nums.length - i - 1)));
      }
    }
    return result;
  }

  private static String findResult(String str, long result) {
    char[] nums = str.toCharArray();
    char maxChar = '0';
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxChar) {
        maxChar = nums[i];
      }
    }
    int startRedix = 0;
    if (maxChar <= 57 && maxChar >= 48) {
      startRedix = maxChar - 48 + 1;
    } else {
      startRedix = 10 + maxChar - 97 + 1;
    }

    long number;
    String res = "Impossible";

    long low = startRedix;
    long high = Math.max(low, result);
    while (low <= high) {
      long mid = (low + high) / 2;
      long temp = parseString2Decimal(str, mid);
      if (temp == result) {
        res = String.valueOf(mid);
        break;
      } else if (temp < 0 || temp > result) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return res;
  }
}
