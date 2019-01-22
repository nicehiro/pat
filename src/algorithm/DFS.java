package algorithm;

public class DFS {

  public static void dfs(Node startNode) {
    dfsIter(startNode);
  }

  public static void dfsIter(Node startNode) {
    visit(startNode);
    if (startNode.child != null) {
      dfsIter(startNode.child);
    }
    if (startNode.brother != null) {
      dfsIter(startNode.brother);
    }
  }

  public static void visit(Node node) {
    // TODO do something
    System.out.println(node.value);
  }

  public static void main(String[] args) {
    DFS dfs = new DFS();
    Node node7 = new Node(7, null, null);
    Node node6 = new Node(6, null, null);
    Node node5 = new Node(5, node7, node6);
    Node node4 = new Node(4, null, node5);
    Node node3 = new Node(3, null, null);
    Node node2 = new Node(2, node4, node3);
    Node node1 = new Node(1, node2, null);

    DFS.dfs(node1);
  }
}

class Node {
  int value;
  Node child;
  Node brother;

  public Node(int value, Node child, Node brother) {
    this.value = value;
    this.child = child;
    this.brother = brother;
  }
}
