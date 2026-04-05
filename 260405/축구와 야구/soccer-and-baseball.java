import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] soccer = new int[N+1];
        int[] baseball = new int[N+1];
        for (int i = 1; i <= N; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }
        // Please write your code here.
        int[][][] dp = new int[N+1][12][10];

        for(int i = 0; i<N+1; i++){
            for(int j = 0; j<12; j++){
                for(int k = 0; k<10;k++){
                    dp[i][j][k] = -1;
                }
            }
        }

        dp[0][0][0] = 0;

        for(int i = 1; i<=N;i++){
            for(int j = 0; j<=11;j++){
                for(int k = 0; k<=9; k++){
                    if(dp[i-1][j][k]!=-1){
                        dp[i][j][k] = Math.max(dp[i][j][k] , dp[i-1][j][k]);
                        if(j!=11) dp[i][j+1][k] = Math.max( dp[i][j+1][k], dp[i-1][j][k] + soccer[i]);
                        if(k!=9) dp[i][j][k+1] = Math.max(dp[i][j][k+1], dp[i-1][j][k] + baseball[i]);
                    }
                }
            }
        }
        int max = 0;

        for(int i = 0; i<N+1;i++){
            max = Math.max(dp[i][11][9], max);
        }
        System.out.println(max);
    }
}