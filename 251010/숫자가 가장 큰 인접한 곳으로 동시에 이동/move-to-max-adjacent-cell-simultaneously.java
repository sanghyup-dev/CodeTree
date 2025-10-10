import java.util.Scanner;

public class Main {

  private static int n;
  private static int m;
  private static int t;
  private static int[][] grid;
  private static int[][] marbleMap;

  public static int[] dx = {0, 0, 1, -1};
  public static int[] dy = {1, -1, 0, 0};

  public static boolean inRange(int x, int y) {
    return x >= 0 && y >= 0 && x < n && y < n;
  }

  public static void move(int x, int y, int[][] tempMap) {
    int dir = -1;
    int max = -1;
    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i];
      int ty = y + dy[i];
      if (inRange(tx, ty) && grid[tx][ty] >= max) {
        dir = i;
        max = grid[tx][ty];
      }
    }
    tempMap[x + dx[dir]][y + dy[dir]] ^= 1;
  }

  public static void iterate() {
    int[][] tempMap = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (marbleMap[i][j] == 1) {
          move(i, j, tempMap);
        }
      }
    }
    marbleMap = tempMap;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    t = sc.nextInt();
    grid = new int[n][n];
    marbleMap = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < m; i++) {
      marbleMap[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
    }
    while (t-- > 0) {
      iterate();
    }
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        cnt += marbleMap[i][j];
      }
    }
    System.out.println(cnt);
  }
}