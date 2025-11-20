import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] memo = new int[n+1];

        memo[2] = 1;
        if(n>2) memo[3] = 1;

        for(int i = 4;i<=n;i++){
            memo[i] = (memo[i-2] + memo[i-3])%10007;
        }

        System.out.println(memo[n]);
    }
}