import java.util.Scanner;

public class Main {

  public static int n;
  public static int m;
  public static int r;
  public static int c;
  public static int[][] grid;

  public static int[] dx = {1, 0, -1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void explodeBomb(int x, int y, int dist) {
    for (int i = 0; i < 4; i++) {
      int tx = x + dx[i] * dist;
      int ty = y + dy[i] * dist;

      if (tx < 0 || ty < 0 || tx >= n || ty >= n || grid[tx][ty] != 0) {
        continue;
      }
      grid[tx][ty] = dist + 1;
    }
  }

  public static void iterate(int dist) {
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] != 0 && grid[i][j] <= dist) {
          explodeBomb(i, j, dist);
        }
      }
    }
  }


  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    r = sc.nextInt() - 1;
    c = sc.nextInt() - 1;
    grid = new int[n][n];

    grid[r][c] = 1;

    for (int i = 0; i < m; i++) {
      iterate(i + 1);
    }

    int cnt = 0;
    for (int[] ints : grid) {
      for (int i : ints) {
        cnt += i != 0 ? 1 : 0;
      }
    }
    System.out.println(cnt);
  }
}