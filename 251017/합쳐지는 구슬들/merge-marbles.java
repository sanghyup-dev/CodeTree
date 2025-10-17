import java.io.*;
import java.util.*;

/**
 * 합쳐지는 구슬들 - 시뮬레이션
 * N(1~50), M(1~N*N), T(1~100)
 */
public class Main {

    static class Ball {
        int id;     // 입력 순서로 부여된 고유 번호(1..M)
        int r, c;   // 위치 (1-index 유지)
        int d;      // 0:U,1:D,2:R,3:L
        int w;      // 무게
        boolean alive = true;

        Ball(int id, int r, int c, int d, int w) {
            this.id = id; this.r = r; this.c = c; this.d = d; this.w = w;
        }
    }

    static int N, M, T;

    // U, D, R, L
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, 1, -1};

    static int dirFromChar(char ch) {
        if (ch == 'U') return 0;
        if (ch == 'D') return 1;
        if (ch == 'R') return 2;
        return 3; // 'L'
    }

    static boolean inRange(int r, int c) {
        return 1 <= r && r <= N && 1 <= c && c <= N;
    }

    static int flipDir(int d) {
        if (d == 0) return 1; // U -> D
        if (d == 1) return 0; // D -> U
        if (d == 2) return 3; // R -> L
        return 2;             // L -> R
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        List<Ball> balls = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            char ch = st.nextToken().charAt(0);
            int w = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, r, c, dirFromChar(ch), w));
        }

        // 시뮬레이션
        for (int t = 0; t < T; t++) {
            // 1) 동시에 이동(벽 처리 포함)
            for (Ball b : balls) {
                if (!b.alive) continue;
                int nr = b.r + dr[b.d];
                int nc = b.c + dc[b.d];
                if (!inRange(nr, nc)) {
                    // 벽에 부딪힘: 그 초에는 이동하지 않고 방향만 반전
                    b.d = flipDir(b.d);
                } else {
                    // 정상 이동
                    b.r = nr; b.c = nc;
                }
            }

            // 2) 같은 칸에 모인 구슬들 합치기
            Map<Integer, List<Ball>> cell = new HashMap<>();
            for (Ball b : balls) {
                if (!b.alive) continue;
                int key = b.r * 100 + b.c; // N<=50이므로 안전. (또는 key = (b.r-1)*N + b.c)
                cell.computeIfAbsent(key, k -> new ArrayList<>()).add(b);
            }

            for (List<Ball> group : cell.values()) {
                if (group.size() <= 1) continue;

                // 합치기: 무게 합 + 가장 큰 id의 방향/번호 유지
                int sumW = 0;
                Ball keep = group.get(0);
                for (Ball b : group) {
                    sumW += b.w;
                    if (b.id > keep.id) keep = b;
                }
                // keep만 남기고 나머지는 제거
                for (Ball b : group) {
                    if (b != keep) b.alive = false;
                }
                keep.w = sumW;
                // keep의 d, id, 위치는 그대로 (가장 큰 id의 방향을 이미 갖고 있음)
            }
        }

        // 결과 집계
        int aliveCnt = 0;
        int maxWeight = 0;
        for (Ball b : balls) {
            if (b.alive) {
                aliveCnt++;
                if (b.w > maxWeight) maxWeight = b.w;
            }
        }
        System.out.println(aliveCnt + " " + maxWeight);
    }
}
