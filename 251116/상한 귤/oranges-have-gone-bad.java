import java.util.*;

public class Main {

    public static class Cords{
        int x;
        int y;

        public Cords(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        int[][] rotten = new int[n][n];
        Queue<Cords> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j]==0) rotten[i][j] = -1;
                if(grid[i][j]==1) rotten[i][j] = -2;
                if(grid[i][j]==2) q.offer(new Cords(i,j));
            }
        }

        int[] dx  = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        while(!q.isEmpty()){
            Cords c = q.poll();
            for(int i = 0; i<4;i++){
                int x = c.x + dx[i];
                int y = c.y + dy[i];
                if(x<0|| y<0|| x>=n|| y>=n || rotten[x][y]!=-2) continue;
                rotten[x][y]= rotten[c.x][c.y]+1;
                q.offer(new Cords(x,y));
            }
        }

        for(int[] line: rotten){
            for(int i: line){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}