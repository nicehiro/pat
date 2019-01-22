import java.util.Scanner;

public class Exer1 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number1 = 0, number2 = 0;
    if (scanner.hasNextInt()) {
      number1 = scanner.nextInt();
    }
    if (scanner.hasNextInt()) {
      number2 = scanner.nextInt();
    }


    String symbol = "";
    int result = number1 + number2;
    if (result < 0) {
      symbol = "-";
    }
    String res = revertInt(Math.abs(result));
    System.out.println(symbol + res);
  }

  private static String revertInt(int result) {
    int yushuNum = result % 1000;
    String yushu = String.valueOf(yushuNum);
    int shang = result / 1000;
    if (shang > 0) {
      if (yushuNum < 10) {
        yushu = "00" + yushuNum;
      } else if (yushuNum < 100) {
        yushu = "0" + yushuNum;
      } else {
        yushu = String.valueOf(yushuNum);
      }
      return revertInt(shang) + "," + yushu;
    }
    return yushu;
  }
}
