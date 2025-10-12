import java.util.Scanner;
import java.util.Stack;

public class Main {

  public static final int BASE = -1;

  public static class Node {

    int val;
    Node nxt;

    public Node(int val, Node nxt) {

      this.val = val;
      this.nxt = nxt;
    }

  }

  private static int n;
  private static int m;
  private static Node[][] grid;

  public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
  public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};


  public static void move(int val) {
    Node prev = null;
    Node toMove = null;
    int toMoveX = -1;
    int toMoveY = -1;

    boolean found = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Node node = grid[i][j];
        while (node.nxt != null) {
          if (node.nxt.val == val) {
            toMove = node.nxt;
            node.nxt = null;
            prev = node;
            toMoveX = i;
            toMoveY = j;
            found = true;
            break;
          }
          node = node.nxt;
        }
        if (found) {
          break;
        }
      }
      if (found) {
        break;
      }
    }

    Node biggest = null;
    int biggestValue = -1;
    for (int i = 0; i < 8; i++) {
      int nx = toMoveX + dx[i];
      int ny = toMoveY + dy[i];
      if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
        continue;
      }
      Node node = grid[nx][ny];
      while (node.nxt != null) {
        if (node.nxt.val > biggestValue) {
          biggestValue = node.nxt.val;
          biggest = node.nxt;
        }
        node = node.nxt;
      }
    }
    if (biggest == null) {
      prev.nxt = toMove;
      return;
    }

    Node toPut = biggest;
    while (toPut.nxt != null) {
      toPut = toPut.nxt;
    }

    toPut.nxt = toMove;

  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    grid = new Node[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = new Node(BASE, null);
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j].nxt = new Node(sc.nextInt(), null);
      }
    }

    for (int i = 0; i < m; i++) {
      move(sc.nextInt());
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        Stack<Integer> stack = new Stack<>();
        if (grid[i][j].nxt == null) {
          System.out.println("None");
        } else {
          Node node = grid[i][j];
          while (node.nxt != null) {
            stack.add(node.nxt.val);
            node = node.nxt;
          }
          while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
          }
          System.out.println();
        }
      }
    }

  }
}