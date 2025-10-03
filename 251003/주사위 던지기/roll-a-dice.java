import java.util.Scanner;

public class Main {

  public static int n;
  public static int m;
  public static int r;
  public static int c;
  public static int[][] grid;

  public static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;

  public static int cur = 6;
  public static int[] surround = {5, 3, 2, 4}; // 상 우 하 좌

  public static int left() {
    surround[RIGHT] = cur;
    cur = surround[LEFT];
    surround[LEFT] = 7 - surround[RIGHT];
    return cur;
  }

  public static int right() {
    surround[LEFT] = cur;
    cur = surround[RIGHT];
    surround[RIGHT] = 7 - surround[LEFT];
    return cur;
  }

  public static int up() {
    surround[DOWN] = cur;
    cur = surround[UP];
    surround[UP] = 7 - surround[DOWN];
    return cur;
  }

  public static int down() {
    surround[UP] = cur;
    cur = surround[DOWN];
    surround[DOWN] = 7 - surround[UP];
    return cur;
  }

  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void move(char dir) {
    if (dir == 'L') {
      int x = r + dx[LEFT];
      int y = c + dy[LEFT];

      if (x >= 0 && y >= 0 && x < n && y < n) {
        r = x;
        c = y;
        grid[r][c] = left();
      }
    }
    if (dir == 'R') {
      int x = r + dx[RIGHT];
      int y = c + dy[RIGHT];

      if (x >= 0 && y >= 0 && x < n && y < n) {
        r = x;
        c = y;
        grid[r][c] = right();
      }
    }
    if (dir == 'U') {
      int x = r + dx[UP];
      int y = c + dy[UP];

      if (x >= 0 && y >= 0 && x < n && y < n) {
        r = x;
        c = y;
        grid[r][c] = up();
      }
    }
    if (dir == 'D') {
      int x = r + dx[DOWN];
      int y = c + dy[DOWN];

      if (x >= 0 && y >= 0 && x < n && y < n) {
        r = x;
        c = y;
        grid[r][c] = down();
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
    grid[r][c] = cur;

    for (int i = 0; i < m; i++) {
      move(sc.next().charAt(0));
    }

    int total = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        total += grid[i][j];
      }
    }
    System.out.println(total);

  }
}