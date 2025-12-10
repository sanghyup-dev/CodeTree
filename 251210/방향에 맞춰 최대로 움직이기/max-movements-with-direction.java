import java.util.Scanner;
public class Main {

    public static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
    public static int[] dy = {0, 0,1,1,1,0,-1,-1,-1};

    public static int n;
    public static int[][] nums;
    public static int[][] moveDir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        moveDir = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                moveDir[i][j] = sc.nextInt();
            }
        }
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;

        iteration(0,r,c);
        System.out.println(mx);
    }

    public static int mx = 0;

    public static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    public static void iteration(int it, int r, int c){
        int dir = moveDir[r][c];
        int x = dx[dir] + r;
        int y = dy[dir] + c;
        while(inRange(x,y)){
            if(nums[r][c] < nums[x][y]){
                iteration(it+1,x,y);
            }
            x+= dx[dir];
            y+= dy[dir];
        }
        mx = Math.max(mx, it);
    }
}