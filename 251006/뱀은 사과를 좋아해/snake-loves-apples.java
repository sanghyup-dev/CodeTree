import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static class Dot {

    int x;
    int y;

    public Dot(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static int n;
  public static int m;
  public static int k;
  public static int[][] grid;

  public static int[] dx = {0, 1, 0, -1};
  public static int[] dy = {1, 0, -1, 0};
  public static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
  public static final int APPLE = 1, SNAKE = -1;

  public static int headX = 0;
  public static int headY = 0;

  public static Queue<Dot> snake = new ArrayDeque<>();

  static {
    snake.add(new Dot(0, 0));
  }

  public static boolean move(int dir) {

    headX += dx[dir];
    headY += dy[dir];

    if (headX < 0 || headX >= n || headY < 0 || headY >= n) {
      return false;
    }

    if (grid[headX][headY] != APPLE) {
      Dot tail = snake.poll();
      grid[tail.x][tail.y] = 0;
    }

    if (grid[headX][headY] == SNAKE) {
      return false;
    }

    snake.add(new Dot(headX, headY));
    grid[headX][headY] = SNAKE;
    return true;
  }

  public static Map<Character, Integer> mapper = new HashMap<>();

  static {
    mapper.put('U', UP);
    mapper.put('D', DOWN);
    mapper.put('R', RIGHT);
    mapper.put('L', LEFT);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    k = sc.nextInt();
    grid = new int[n][n];
    grid[0][0] = SNAKE;
    for (int i = 0; i < m; i++) {
      int x = sc.nextInt() - 1;
      int y = sc.nextInt() - 1;
      grid[x][y] = APPLE;
    }

    int cnt = 0;
    for (int i = 0; i < k; i++) {
      int d = mapper.get(sc.next().charAt(0));
      int p = sc.nextInt();

      for (int j = 0; j < p; j++) {
        cnt++;
        if (!move(d)) {
          System.out.println(cnt);
          System.exit(0);
        }

      }
    }
    System.out.println(cnt);

  }
}