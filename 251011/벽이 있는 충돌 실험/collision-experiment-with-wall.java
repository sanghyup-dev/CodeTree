import java.io.*;
import java.util.*;

public class Main {

  static final int RIGHT = 0, DOWN = 1, LEFT = 2, UP = 3;
  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};

  static int dirOf(char c) {
    return (c == 'R') ? RIGHT : (c == 'D') ? DOWN : (c == 'L') ? LEFT : UP;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder out = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine().trim());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      // store balls in flat arrays (0-based)
      int[] x = new int[m];
      int[] y = new int[m];
      int[] d = new int[m];
      boolean[] alive = new boolean[m];
      Arrays.fill(alive, true);

      for (int i = 0; i < m; i++) {
        st = new StringTokenizer(br.readLine());
        x[i] = Integer.parseInt(st.nextToken()) - 1;
        y[i] = Integer.parseInt(st.nextToken()) - 1;
        d[i] = dirOf(st.nextToken().charAt(0));
      }

      // counts per cell; n<=50 so n*n<=2500 (cheap to clear)
      int area = n * n;
      int[] cnt = new int[area];
      int[] nx = new int[m], ny = new int[m], nd = new int[m];

      // With "pause at wall", axis period = 2n, so simulate up to 2n steps.
      int steps = 2 * n;
      for (int step = 0; step < steps; step++) {
        if (m == 0) {
          break;
        }

        // 1) compute tentative next state & count landings
        Arrays.fill(cnt, 0);
        for (int i = 0; i < m; i++) {
          if (!alive[i]) {
            continue;
          }
          int tx = x[i] + dx[d[i]];
          int ty = y[i] + dy[d[i]];

          if (tx < 0 || tx >= n || ty < 0 || ty >= n) {
            // hit wall: stay, flip direction (costs 1s)
            nx[i] = x[i];
            ny[i] = y[i];
            nd[i] = (d[i] + 2) % 4;
          } else {
            nx[i] = tx;
            ny[i] = ty;
            nd[i] = d[i];
          }
          cnt[nx[i] * n + ny[i]]++;
        }

        // 2) resolve collisions (cells with count >= 2)
        boolean anyCollision = false;
        for (int i = 0; i < m; i++) {
          if (!alive[i]) {
            continue;
          }
          int id = nx[i] * n + ny[i];
          if (cnt[id] >= 2) {
            alive[i] = false;
            anyCollision = true;
          }
        }

        // 3) commit survivors
        for (int i = 0; i < m; i++) {
          if (!alive[i]) {
            continue;
          }
          x[i] = nx[i];
          y[i] = ny[i];
          d[i] = nd[i];
        }

        // Optional micro-early exit: if no collision and all balls are away from walls
        // you could break; but with steps <= 100 it's not necessary.
      }

      int survivors = 0;
      for (int i = 0; i < m; i++) {
        if (alive[i]) {
          survivors++;
        }
      }
      out.append(survivors).append('\n');
    }

    System.out.print(out.toString());
  }
}
