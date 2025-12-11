import java.util.Scanner;

public class Main {

    public static int n;
    public static int m;
    public static int[] A;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        findXOR(-1,0,0);
        System.out.print(maxVal);
    }

    public static int maxVal = 0;

    public static void findXOR(int cur, int cnt, int curVal){
        if(cnt==m){
            maxVal = Math.max(maxVal, curVal);
            return;
        }
        for(int i = cur+1; i<n;i++){
            findXOR(i,cnt+1,curVal^A[i]);
        }
    }


}