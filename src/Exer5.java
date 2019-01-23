import java.util.Scanner;

public class Exer5 {
  private static String[] int2Eng = {"zero", "one", "two", "three", "four", "five", "six",
      "seven", "eight", "nine"};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String numberStr = scanner.next();
    int result = sumNum(numberStr);
    if (result == 0) {
      System.out.println(int2Eng[0]);
    } else {
      System.out.println(number2Eng(result).trim());
    }
  }

  private static int sumNum(String numberStr) {
    char[] strs = numberStr.toCharArray();
    int result = 0;
    for (char str : strs) {
      result += Integer.parseInt(String.valueOf(str));
    }
    return result;
  }

  /**
   * 递归求数和.
   *
   * @param number 整形数.
   * @return 和.
   * @deprecated 题目中的数太大了，不能直接计算.
   */
  private static int sumNum(int number) {
    if (number == 0) {
      return 0;
    }
    return number % 10 + sumNum(number / 10);
  }

  private static String number2Eng(int number) {
    if (number == 0) {
      return "";
    }
    return number2Eng(number / 10) + " " + int2Eng[number % 10];
  }
}
