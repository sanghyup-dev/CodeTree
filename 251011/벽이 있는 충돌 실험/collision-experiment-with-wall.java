import java.io.*;
import java.util.*;

public class Main {
  static final int R = 0, D = 1, L = 2, U = 3;
  static final int[] dx = {0, 1, 0, -1};
  static final int[] dy = {1, 0, -1, 0};

  static final class FastScanner {
    private final InputStream in;
    private final byte[] buffer = new byte[1 << 16];
    private int ptr = 0, len = 0;
    FastScanner(InputStream is) { in = is; }
    private int read() throws IOException {
      if (ptr >= len) { len = in.read(buffer); ptr = 0; if (len <= 0) return -1; }
      return buffer[ptr++];
    }
    int nextInt() throws IOException {
      int c, s = 1, x = 0;
      do c = read(); while (c <= 32);
      if (c == '-') { s = -1; c = read(); }
      while (c > 32) { x = x * 10 + (c - '0'); c = read(); }
      return x * s;
    }
    char nextCharNonSpace() throws IOException {
      int c; do c = read(); while (c <= 32); return (char)c;
    }
  }

  static int dirOf(char c) {
    switch (c) {
      case 'R': return R;
      case 'D': return D;
      case 'L': return L;
      default:  return U;
    }
  }

  public static void main(String[] args) throws Exception {
    FastScanner fs = new FastScanner(System.in);
    StringBuilder out = new StringBuilder();

    int T = fs.nextInt();
    while (T-- > 0) {
      int n = fs.nextInt();
      int m = fs.nextInt();

      // Packed arrays
      int[] x = new int[m];
      int[] y = new int[m];
      int[] d = new int[m];
      for (int i = 0; i < m; i++) {
        x[i] = fs.nextInt() - 1;   // 0-based
        y[i] = fs.nextInt() - 1;
        d[i] = dirOf(fs.nextCharNonSpace());
      }
      int alive = m;

      // Per-tick buffers
      int area = n * n;
      int[] cnt = new int[area];           // landing counts
      int[] nx = new int[m], ny = new int[m], nd = new int[m];
      int[] touched = new int[area];       // list of cells touched this tick
      int touchedTop;

      // simulate up to 2n steps (period upper bound)
      int steps = 2 * n;
      for (int step = 0; step < steps && alive > 1; step++) {
        touchedTop = 0;

        // 1) compute next positions & counts for packed [0..alive-1]
        for (int i = 0; i < alive; i++) {
          int tx = x[i] + dx[d[i]];
          int ty = y[i] + dy[d[i]];
          if (tx < 0 || tx >= n || ty < 0 || ty >= n) {
            nx[i] = x[i];
            ny[i] = y[i];
            nd[i] = (d[i] + 2) % 4;        // flip, stay
          } else {
            nx[i] = tx;
            ny[i] = ty;
            nd[i] = d[i];
          }
          int id = nx[i] * n + ny[i];
          if (cnt[id] == 0) touched[touchedTop++] = id; // remember to clear later
          cnt[id]++;
        }

        // 2) remove collided balls by swap-removal
        int write = 0;
        for (int i = 0; i < alive; i++) {
          int id = nx[i] * n + ny[i];
          if (cnt[id] >= 2) {
            // kill (skip copying)
          } else {
            // keep; pack into [0..write-1]
            x[write] = nx[i];
            y[write] = ny[i];
            d[write] = nd[i];
            write++;
          }
        }
        alive = write;

        // 3) clear only touched counters
        for (int k = 0; k < touchedTop; k++) cnt[touched[k]] = 0;

        if (alive <= 1) break; // optional micro-early exit
      }

      out.append(alive).append('\n');
    }
    System.out.print(out);
  }
}
