import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

  public static class Ball {

    int x;
    int y;
    int dir;

    public Ball(int x, int y, int dir) {
      this.x = x;
      this.y = y;
      this.dir = dir;
    }
  }

  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {1, 0, -1, 0};

  public static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;

  public static Map<Character, Integer> mapper = new HashMap<>();

  static {
    mapper.put('R', RIGHT);
    mapper.put('D', DOWN);
    mapper.put('L', LEFT);
    mapper.put('U', UP);
  }

  private static int t;
  private static int n;
  private static int m;
  public static Set<Ball> balls;

  public static Set<Ball>[][] grid;

  public static boolean inRange(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < n;
  }

  public static void move(Ball ball) {
    int x = ball.x + dx[ball.dir];
    int y = ball.y + dy[ball.dir];
    if (!inRange(x, y)) {
      ball.dir = (ball.dir + 2) % 4;
      grid[ball.x][ball.y].add(ball);
    } else {
      ball.x += dx[ball.dir];
      ball.y += dy[ball.dir];
      grid[x][y].add(ball);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    t = sc.nextInt();
    while (t-- > 0) {
      n = sc.nextInt();
      m = sc.nextInt();
      balls = new HashSet<>();
      for (int i = 0; i < m; i++) {
        int x = sc.nextInt();
        int y = sc.nextInt();
        char d = sc.next().charAt(0);
        balls.add(new Ball(x, y, mapper.get(d)));
      }

      for (int i = 0; i < 2 * n + 2; i++) {
        grid = new Set[n][n];
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < n; k++) {
            grid[j][k] = new HashSet<>();
          }
        }
        for (Ball ball : balls) {
          move(ball);
        }
        for (int j = 0; j < n; j++) {
          for (int k = 0; k < n; k++) {
            if (grid[i][j].size() > 1) {
              balls.removeAll(grid[i][j]);
            }
          }
        }
      }
      System.out.println(balls.size());
    }
  }
}