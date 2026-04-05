import java.util.*;
import java.lang.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.

        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i<=n; i++){
            dp[i][1] = Math.max(matrix[i][1], dp[i-1][1]);
            dp[1][i] =  Math.max(matrix[1][i], dp[1][i-1]);
        }

        for(int i  = 2; i<=n; i++){
            for(int j = 2; j<=n; j++){
                dp[i][j] = Math.max(matrix[i][j], Math.min(dp[i-1][j], dp[i][j-1]));
            }
        }

        System.out.println(dp[n][n]);
    }
}