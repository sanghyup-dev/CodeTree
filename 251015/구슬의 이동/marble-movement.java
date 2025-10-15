import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static int[] dx = {1, 0, -1, 0};
  public static int[] dy = {0, -1, 0, 1};

  public static final int DOWN = 0, LEFT = 1, UP = 2, RIGHT = 3;

  public static int mapDirs(char c) {
    return c == 'D' ? DOWN : c == 'R' ? RIGHT : c == 'L' ? LEFT : UP;
  }

  private static int n;
  private static int m;
  private static int t;
  private static int k;

  public static class Ball {

    int id;
    int d;
    int v;
    int r;
    int c;
    boolean isAlive = true;

    public Ball(int r, int c, int id, int d, int v) {
      this.r = r;
      this.c = c;
      this.id = id;
      this.d = d;
      this.v = v;
    }
  }

  public static List<Ball> balls = new ArrayList<>();

  public static void move(Ball ball) {
    for (int i = 0; i < ball.v; i++) {
      int x = ball.r + dx[ball.d];
      int y = ball.c + dy[ball.d];
      if (x < 0 || y < 0 || x >= n || y >= n) {
        ball.d = (ball.d + 2) % 4;
        x = ball.r + dx[ball.d];
        y = ball.c + dy[ball.d];
      }
      ball.r = x;
      ball.c = y;
    }
  }

  public static void iter() {
    for (Ball ball : balls) {
      if (ball.isAlive) {
        move(ball);
      }
    }
    balls.sort(Comparator.comparingInt((Ball ball) -> ball.r)
        .thenComparingInt(ball -> ball.c)
        .thenComparingInt(ball -> ball.v)
        .thenComparingInt(ball -> ball.id));

    int curR = 0;
    int curC = 0;
    int cnt = 0;

    for (Ball ball : balls) {
      if (ball.r == curR && ball.c == curC) {
        cnt++;
        if (cnt > k) {
          ball.isAlive = false;
        }
      } else {
        cnt = 1;
        curR = ball.r;
        curC = ball.c;
      }
    }
    balls.removeIf(ball -> !ball.isAlive);
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    n = sc.nextInt();
    m = sc.nextInt();
    t = sc.nextInt();
    k = sc.nextInt();

    for (int i = 0; i < m; i++) {
      int r = sc.nextInt() - 1;
      int c = sc.nextInt() - 1;
      char d = sc.next().charAt(0);
      int v = sc.nextInt();
      balls.add(new Ball(r, c, i + 1, mapDirs(d), v));
    }

    while (t-- > 0) {
      iter();
    }
    System.out.println(balls.size());
  }
}