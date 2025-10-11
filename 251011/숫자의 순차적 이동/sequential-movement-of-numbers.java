import java.util.Scanner;

public class Main {

  public static class Cord {

    int x;
    int y;

    public Cord(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int[] dx = {0, -1, -1, -1, 0, 0, 1, 1, 1};
  public static int[] dy = {0, -1, 0, 1, -1, 1, -1, 0, 1};

  private static int n;
  private static int m;
  private static int[][] grid;
  public static Cord[] mapping;

  public static boolean inRange(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
  }

  public static void move(int cur, Cord cord) {
    int maxDir = 0;
    int max = -1;
    for (int i = 1; i <= 8; i++) {
      int x = cord.x + dx[i];
      int y = cord.y + dy[i];

      if (inRange(x, y) && max < grid[x][y]) {
        max = grid[x][y];
        maxDir = i;
      }
    }
    mapping[cur] = mapping[max];
    mapping[max] = cord;

    grid[cord.x][cord.y] = max;
    grid[cord.x + dx[maxDir]][cord.y + dy[maxDir]] = cur;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    grid = new int[n][n];
    mapping = new Cord[n * n + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
        mapping[grid[i][j]] = new Cord(i, j);
      }
    }
    while (m-- > 0) {
      for (int i = 1; i <= n * n; i++) {
        move(i, mapping[i]);
      }
    }

    for (int[] ints : grid) {
      for (int i : ints) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}