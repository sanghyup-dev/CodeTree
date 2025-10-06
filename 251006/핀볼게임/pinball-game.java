import java.util.Scanner;

public class Main {


  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {1, 0, -1, 0};

  public static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
  public static final int DOWN_TO_UP = 1, UP_TO_DOWN = 2;

  public static int n;
  public static int[][] grid;
  public static int dir = DOWN;


  public static void downUp() {
    if (dir == UP) {
      dir = RIGHT;
    }
    if (dir == LEFT) {
      dir = DOWN;
    }
    if (dir == RIGHT) {
      dir = UP;
    }
    if (dir == DOWN) {
      dir = LEFT;
    }
  }

  public static void upDown() {
    if (dir == UP) {
      dir = LEFT;
    }
    if (dir == LEFT) {
      dir = UP;
    }
    if (dir == RIGHT) {
      dir = DOWN;
    }
    if (dir == DOWN) {
      dir = RIGHT;
    }
  }

  public static int findLength(int x, int y, int d) {
    dir = d;
    int cnt = 1;
    while (x >= 0 && y >= 0 && x < n && y < n) {
      if (grid[x][y] == DOWN_TO_UP) {
        downUp();
      } else if (grid[x][y] == UP_TO_DOWN) {
        upDown();
      }
      x += dx[dir];
      y += dy[dir];
      cnt++;
    }
    return cnt;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    int ans = 0;
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, findLength(0, i, DOWN));
    }
    for (int i = 0; i < n; i++) {
      ans = Math.max(ans, findLength(i, n - 1, LEFT));
    }
    for (int i = n - 1; i >= 0; i--) {
      ans = Math.max(ans, findLength(n - 1, i, UP));
    }
    for (int i = n - 1; i >= 0; i--) {
      ans = Math.max(ans, findLength(i, 0, RIGHT));
    }
    System.out.println(ans);

  }
}