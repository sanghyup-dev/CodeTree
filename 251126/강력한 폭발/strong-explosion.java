import java.util.*;
public class Main {

    static int n;
    static int[][] grid;

    static List<Integer> bombsX = new ArrayList<>();
    static List<Integer> bombsY = new ArrayList<>();
    static List<Integer> bombType = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sc.nextInt() == 1){
                    bombsX.add(i);
                    bombsY.add(j);
                }
            }
        }
        getBiggestExplostion(0);
        System.out.println(max);
    }

    public static int[][] BombDx = {{1,2,-1,-2},{1,0,-1,0},{1,1,-1,-1}};
    public static int[][] BombDy = {{0,0,0,0}, {0,1,0,-1}, {1,-1,1,-1}};


    public static int max = -1;

    public static void getBiggestExplostion(int it){
        if(it == bombsX.size()){
            grid = new int[n][n];
            for(int i = 0; i<bombsX.size(); i++){
                grid[bombsX.get(i)][bombsY.get(i)] = bombType.get(i);
            }
            max = Math.max(max, calculate(grid));
            return;
        }

        for(int i = 1; i<=3;i++){
            bombType.add(i);
            getBiggestExplostion(it+1);
            bombType.remove(bombType.size()-1);
        }
    }

    public static int calculate(int[][] arr){
        for(int i = 0; i<n; i++ ){
            for(int j = 0; j<n;j++){
                for(int k = 0; k<4;k++){
                    if(arr[i][j]==1 || arr[i][j]==2 || arr[i][j]==3){
                        int x = i+ BombDx[arr[i][j]-1][k];
                        int y = j+ BombDy[arr[i][j]-1][k];

                        if(x<0||y<0|| x>=n||y>=n) continue;
                        if(arr[x][y]!=0) continue;

                       arr[x][y] = -1; 
                    }
                }
            }
        }
        int cnt = 0;
        for(int i = 0; i<n; i++ ){
            for(int j = 0; j<n;j++){
                if(arr[i][j] !=0) cnt++;
            }
        }
        return cnt;
    }
}