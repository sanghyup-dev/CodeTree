import java.util.*;

public class Main {

    public static int n;
    public static int m;
    public static int c;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        c = sc.nextInt();

        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int maxValue = 0;

        // 첫 번째 도둑 구간 선택
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 <= n - m; c1++) {

                List<Integer> first = new ArrayList<>();
                for (int k = 0; k < m; k++) {
                    first.add(grid[r1][c1 + k]);
                }
                int firstBest = bestValue(first);

                // 두 번째 도둑 구간 선택
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = 0; c2 <= n - m; c2++) {

                        // 같은 행이면 겹치는지 체크
                        if (r1 == r2) {
                            int end1 = c1 + m - 1;
                            int end2 = c2 + m - 1;
                            boolean overlap = !(end1 < c2 || end2 < c1);
                            if (overlap) continue;
                        }

                        List<Integer> second = new ArrayList<>();
                        for (int k = 0; k < m; k++) {
                            second.add(grid[r2][c2 + k]);
                        }
                        int secondBest = bestValue(second);

                        maxValue = Math.max(maxValue, firstBest + secondBest);
                    }
                }
            }
        }

        System.out.println(maxValue);
        sc.close();
    }

    // candidates: 길이 m인 한 구간의 값들
    // 각 값 w에 대해, w들의 합 <= c 이면서 sum(w^2)가 최대가 되도록 선택
    public static int bestValue(List<Integer> candidates) {
        int len = candidates.size();
        int[][] dp = new int[len + 1][c + 1];

        for (int i = 1; i <= len; i++) {
            int w = candidates.get(i - 1);
            int val = w * w;
            for (int cap = 0; cap <= c; cap++) {
                // 안 담는 경우
                dp[i][cap] = dp[i - 1][cap];
                // 담는 경우
                if (cap >= w) {
                    dp[i][cap] = Math.max(dp[i][cap],
                            dp[i - 1][cap - w] + val);
                }
            }
        }

        int result = 0;
        for (int cap = 0; cap <= c; cap++) {
            result = Math.max(result, dp[len][cap]);
        }
        return result;
    }
}
