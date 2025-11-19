import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        findMaxMin(0,Integer.MAX_VALUE);
        System.out.println(max);
    }

    public static int max = -1;
    public static boolean[] used;

    public static void findMaxMin(int iter, int min){
        if(iter == n){
            max = Math.max(min, max);
            return;
        }

        for(int i = 0; i<n;i++){
            if(used[i]) continue;
            used[i] = true;
            int prevMin = min;
            min = Math.min(min, grid[iter][i]);
            findMaxMin(iter+1, min);
            used[i] = false;
            min = prevMin;
        }
    }
}