import java.util.Scanner;

public class Main {

  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {1, 0, -1, 0};

  public static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

  public static int[][] maze;
  public static int n;
  public static int x;
  public static int y;
  public static int dir = RIGHT;
  public static int forwardCount = 0;

  public static void forward() {
    x += dx[dir];
    y += dy[dir];
    forwardCount++;
  }

  public static void turnRight() {
    dir = (dir + 1) % 4;
  }

  public static void turnLeft() {
    dir = (dir + 3) % 4;
  }

  public static boolean step() {/* returns isFinish*/
    int r = x + dx[dir];
    int c = y + dy[dir];
    if (r < 0 || r >= n || c < 0 || c >= n) {
      forwardCount++;
      return true;
    }
    if (maze[r][c] == 1) {
      turnLeft();
    } else {
      forward();
      r = x + dx[(dir + 1) % 4];
      c = y + dy[(dir + 1) % 4];
      if (r < 0 || r >= n || c < 0 || c >= n) {
        forwardCount++;
        return true;
      }
      if (maze[r][c] == 0) {
        turnRight();
        forward();
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    x = sc.nextInt() - 1;
    y = sc.nextInt() - 1;
    maze = new int[n][n];
    for (int i = 0; i < n; i++) {
      String line = sc.next();
      for (int j = 0; j < n; j++) {
        maze[i][j] = line.charAt(j) == '.' ? 0 : 1;
      }
    }
    int cnt = 4 * n * n;
    while (!step() && cnt-- > 0)
      ;
    System.out.println(cnt == 0 ? -1 : forwardCount);
  }
}