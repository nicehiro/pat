import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exer9 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Map<Integer, Float> map1 = new HashMap<>();
    Map<Integer, Float> map2 = new HashMap<>();
    TreeMap<Integer, Float> result = new TreeMap<>();
    int num = scanner.nextInt();
    for (int j = 0; j < num; j++) {
      int exp = scanner.nextInt();
      float coe = scanner.nextFloat();
      map1.put(exp, coe);
    }

    num = scanner.nextInt();
    for (int i = 0; i < num; i++) {
      int exp = scanner.nextInt();
      float coe = scanner.nextFloat();
      map2.put(exp, coe);
    }

    for (Map.Entry<Integer, Float> entry : map1.entrySet()) {
      for (Map.Entry<Integer, Float> entry1 : map2.entrySet()) {
        int key = entry.getKey() + entry1.getKey();
        Float value = entry.getValue() * entry1.getValue();
        result.put(key, (result.containsKey(key) ? result.get(key) + value : value));
      }
    }

    String str = String.valueOf(result.size());
    DecimalFormat decimalFormat = new DecimalFormat(".0");
    for (Map.Entry<Integer, Float> entry : result.descendingMap().entrySet()) {
      str = str + " " + entry.getKey() + " " + decimalFormat.format(entry.getValue());
    }
    System.out.println(str);
  }
}
