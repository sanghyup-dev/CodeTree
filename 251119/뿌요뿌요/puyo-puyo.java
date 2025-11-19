import java.util.Scanner;

public class Main {

    public static int n;
    public static int[][] grid;
    public static boolean[][] visited;
    public static int max;
    public static int explodeCnt;

    public static int[] dx = {1,0,-1,0};
    public static int[] dy = {0,1,0,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(!visited[i][j]) findLength(i,j);

        System.out.println(explodeCnt+" "+max);
    }

    public static int currentCnt;

    public static void findConnected(int x, int y){ //메인에서 호출 전 currentCnt 0으로 초기화 필요
        for(int i = 0; i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || ny<0 || nx>=n || ny>=n || visited[nx][ny] || grid[nx][ny]!=grid[x][y]){
                continue;
            }

            currentCnt++;
            visited[nx][ny] = true;
            findConnected(nx, ny);
        }
    }

    public static void findLength(int x, int y){
        currentCnt = 0;
        findConnected(x,y);
        max = Math.max(max, currentCnt);
        if(currentCnt>=4) explodeCnt++;
    }


}