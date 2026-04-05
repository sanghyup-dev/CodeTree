import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int total = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        if(total%2==1){
            System.out.println("No");
            return;
        }
        // Please write your code here.
        boolean[] dp = new boolean[100004];
        dp[0] = true;

        for(int i = 0; i<n; i++){
            for(int j = 100002-arr[i]; j>=0; j--){
                if(dp[j]==true) dp[j+arr[i]] = true;
            }
        }
        if(dp[total/2])      System.out.println("Yes");
        else             System.out.println("No");

    }
}