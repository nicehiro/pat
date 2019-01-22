import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author hiro
 */
public class Exer2 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TreeMap<Integer, Float> map = new TreeMap<>();
    for (int i=0; i<2; i++) {
      int times = scanner.nextInt();
      int key = 1001;
      if (times <= 10 && times >= 1) {
        for (int j=0; j<times; j++) {
          int temp = scanner.nextInt();
          float value = scanner.nextFloat();
          if (temp < key) {
            key = temp;
            if (key <= 1000 && key >= 0) {
              if (!map.containsKey(key)) {
                map.put(key, value);
              } else if ((value + map.get(key)) != 0) {
                map.put(key, value + map.get(key));
              } else {
                map.remove(key);
              }
            }
          }
        }
      }
    }
    System.out.println(formatMap(map.descendingMap()));
  }

  private static String formatMap(Map<Integer, Float> map) {
    StringBuilder result = new StringBuilder(String.valueOf(map.size()));
    DecimalFormat decimalFormat = new DecimalFormat(".0");
    for (Map.Entry<Integer, Float> entry : map.entrySet()) {
      String value = decimalFormat.format(entry.getValue());
      result.append(" ").append(entry.getKey()).append(" ").append(value);
    }
    return result.toString();
  }
}
