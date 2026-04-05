import java.util.*;

public class Main {

    private static class Alba{
        int s;
        int e;
        long p;
        public Alba(int s, int e, long p){
            this.s = s;
            this.e = e;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayList<Alba> albas = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            albas.add(new Alba(sc.nextInt(), sc.nextInt(), sc.nextLong()));
        }

        long[] dp = new long[n];

        dp[0] = albas.get(0).p;

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1], albas.get(i).p);

            for(int j = 0; j < i; j++){
                if(albas.get(j).e < albas.get(i).s){
                    dp[i] = Math.max(dp[i], albas.get(i).p + dp[j]);
                }
            }
        }

        System.out.println(dp[n-1]);
    }
}