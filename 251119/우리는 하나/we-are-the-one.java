import java.util.*;

public class Main {

    public static int n;
    public static int k;
    public static int u;
    public static int d;

    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static int[][] grid;
    public static boolean[][] visited;
    public static Queue<Point> q = new ArrayDeque<>();

    // 선택된 시작 도시들
    public static Point[] starts;
    public static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();

        grid = new int[n][n];
        visited = new boolean[n][n];
        starts = new Point[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // K개 도시 선택 시작
        findMax(0, 0);  // (몇 개 골랐는지, 다음에 볼 위치 인덱스)

        System.out.println(max);
    }

    // pos: 0 ~ n*n-1 (그리드를 1차원으로 펴서 조합 만들기)
    public static void findMax(int picked, int pos) {
        if (picked == k) {
            int reachable = findCanGoCities();  // BFS로 갈 수 있는 도시 수
            max = Math.max(max, reachable);
            return;
        }

        int total = n * n;
        for (int idx = pos; idx < total; idx++) {
            int x = idx / n;
            int y = idx % n;
            starts[picked] = new Point(x, y);
            findMax(picked + 1, idx + 1);   // 조합이니까 idx+1부터
        }
    }

    // 선택된 starts[]를 시작점으로 BFS
    public static int findCanGoCities() {
        // visited, q, cnt 초기화
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }
        q.clear();
        int cnt = 0;

        // K개의 시작 도시를 큐에 넣기
        for (int i = 0; i < k; i++) {
            Point s = starts[i];
            if (!visited[s.x][s.y]) {   // 혹시나 같은 도시가 중복돼도 한 번만
                visited[s.x][s.y] = true;
                q.add(s);
                cnt++;
            }
        }

        // BFS
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int dir = 0; dir < 4; dir++) {
                int x = p.x + dx[dir];
                int y = p.y + dy[dir];
                if (x < 0 || y < 0 || x >= n || y >= n) continue;
                if (visited[x][y]) continue;

                int dif = Math.abs(grid[p.x][p.y] - grid[x][y]);
                if (dif < u || dif > d) continue;

                visited[x][y] = true;
                cnt++;
                q.add(new Point(x, y));
            }
        }

        return cnt;
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
