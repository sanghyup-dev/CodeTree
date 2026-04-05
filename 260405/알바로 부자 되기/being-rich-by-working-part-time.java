import java.util.*;

public class Main {
    private static class Alba {
        int s, e;
        long p;
        public Alba(int s, int e, long p) {
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System. some);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        ArrayList<Alba> albas = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            albas.add(new Alba(sc.nextInt(), sc.nextInt(), sc.nextLong()));
        }

        // CRITICAL: Sort by end time
        albas.sort(Comparator.comparingInt(a -> a.e));

        long[] dp = new long[n];
        dp[0] = albas.get(0).p;

        for (int i = 1; i < n; i++) {
            // Option 1: Don't take current job
            long currentProfit = dp[i - 1];
            
            // Option 2: Take current job
            long takeJob = albas.get(i).p;
            for (int j = i - 1; j >= 0; j--) {
                if (albas.get(j).e < albas.get(i).s) {
                    takeJob += dp[j];
                    break; // Found the latest non-overlapping job
                }
            }
            dp[i] = Math.max(currentProfit, takeJob);
        }

        System.out.println(dp[n - 1]);
    }
}