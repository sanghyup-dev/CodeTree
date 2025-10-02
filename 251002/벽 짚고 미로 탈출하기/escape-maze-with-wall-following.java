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

  public static boolean isFinishFront() {
    int tx = x + dx[dir];
    int ty = y + dy[dir];
    return tx < 0 || ty < 0 || tx >= n || ty >= n;
  }

  public static boolean isWallFront() {
    int tx = x + dx[dir];
    int ty = y + dy[dir];
    return maze[tx][ty] == 1;
  }

  public static boolean isWallDiagonal() {
    int tx = x + dx[dir] + dx[(dir + 1) % 4];
    int ty = y + dy[dir] + dy[(dir + 1) % 4];
    return maze[tx][ty] == 1;
  }


  public static void move() {
    if (isFinishFront()) {
      forward();
      System.out.println(forwardCount);
      System.exit(0);
    }
    if (isWallFront()) {
      turnLeft();
      return;
    }
    if (isWallDiagonal()) {
      forward();
    } else {
      forward();
      turnRight();
      forward();
    }
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

    while (cnt > forwardCount) {
      move();
    }
    System.out.println(-1);


  }
}