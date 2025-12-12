import java.util.Scanner;
public class Main {

    public static int n;
    public static int[] arr;
    public static int total = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
            total+=arr[i];
        }

        getSum(0,-1,0);
        System.out.println(minDiff);
        
    }

    public static int minDiff = Integer.MAX_VALUE;

    public static void getSum(int cnt, int cur, int sum){
        if(cnt==n){
            minDiff = Math.min(minDiff, Math.abs(total-2*sum));
            return;
        }

        for(int i = cur+1; i<2*n;i++){
            getSum(cnt+1, i, sum+arr[i]);
        }
    }
}