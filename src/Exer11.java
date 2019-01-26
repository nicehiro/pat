import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 这个题目我测试的结果是正确的，但是通不过PAT的测试.
 * 思路和其他人的思路相同，时间也没有超过，现在还没有想出是什么问题……
 */
public class Exer11 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TreeMap<Double, String> temp = new TreeMap<>();
    String result = "";
    double[] win = new double[3];
    for (int i = 0; i < 3; i++) {
      double w = scanner.nextDouble();
      double t = scanner.nextDouble();
      double l = scanner.nextDouble();
      temp.put(w, "W");
      temp.put(t, "T");
      temp.put(l, "L");
      win[i] = temp.lastKey();
      result += temp.lastEntry().getValue() + " ";
    }
    double res = (win[0] * win[1] * win[2] * 0.65 - 1) * 2 + 0.0000000001;
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    System.out.println(result + decimalFormat.format(res));
  }
}
