import java.util.*;

public class Exer4 {
  Map<Integer, Integer> book = new HashMap<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int total = scanner.nextInt();
    int nonLeaf = scanner.nextInt();

    Map<String, List<String>> nodeMap = new HashMap<>();
    for (int i = 0; i < nonLeaf; i++) {
      String node = scanner.next();
      int childNumber = scanner.nextInt();
      for (int j = 0; j < childNumber; j++) {
        String childNode = scanner.next();
        if (!nodeMap.containsKey(node)) {
          List<String> temp = new ArrayList<>();
          temp.add(childNode);
          nodeMap.put(node, temp);
        } else {
          nodeMap.get(node).add(childNode);
        }
      }
    }

    Exer4 exer4 = new Exer4();
    exer4.dfs("01", nodeMap, 0);
    String result = "";
    for (int i=0; i<exer4.book.size(); i++) {
      result += exer4.book.get(i) + " ";
    }
    System.out.println(result.trim());
  }

  private void dfs(String root, Map<String, List<String>> nodeMap, int depth) {
    if (nodeMap.get(root) == null || nodeMap.get(root).isEmpty()) {
      if (book.containsKey(depth)) {
        book.put(depth, book.get(depth) + 1);
      } else {
        book.put(depth, 1);
      }
    } else {
      if (!book.containsKey(depth)) {
        book.put(depth, 0);
      }
      for (int i = 0; i < nodeMap.get(root).size(); i++) {
        dfs(nodeMap.get(root).get(i), nodeMap, depth + 1);
      }
    }
  }
}
