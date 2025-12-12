import java.util.*;
public class Main {

    public static int N;
    public static List<Point> coins = new ArrayList<>();
    public static Point end= new Point(-1,-1,-1);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Point start = new Point(-1,-1,-1);


        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for(int j = 0; j< N;j++){
                char c = line.charAt(j);
                if(c=='S') start = new Point(-1, i,j);
                else if(c=='E') end = new Point(Integer.MAX_VALUE, i,j);
                else if(c!='.') coins.add(new Point(c-'0',i,j));
            }
        }

        coins.add(0,start);

        coins.sort((x,y)->x.num-y.num);
        getDistance(0,0,0);
        System.out.println(minDist==Integer.MAX_VALUE?-1:minDist);
    }

    public static int minDist = Integer.MAX_VALUE;

    public static void getDistance(int passedCnt, int cur, int dist){
        if(passedCnt == 3){
            dist+=calcDist(end, coins.get(cur));
            minDist = Math.min(minDist, dist);
            return;
        }
        for(int i = cur+1; i<coins.size(); i++){
            getDistance(passedCnt+1,i,dist+calcDist(coins.get(cur), coins.get(i)));
        }
    }

    public static int calcDist(Point a, Point b){
        return Math.abs(a.x-b.x)+Math.abs(a.y-b.y);
    }

    public static class Point{
        int num;
        int x;
        int y;

        Point(int num, int x, int y){
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
}