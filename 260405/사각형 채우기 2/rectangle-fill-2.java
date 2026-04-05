import java.util.*;

public class Main {

    public static int[] dp = new int[1002];

    public static int findNofPossibilities(int n){
        if (dp[n]!=0) {
            return dp[n];
        }

        return dp[n] = ((findNofPossibilities(n-1) + findNofPossibilities(n-2)*2))%10007;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp[0] = 1;
        dp[1] = 1;

        System.out.println(findNofPossibilities(sc.nextInt()));
    }
}
