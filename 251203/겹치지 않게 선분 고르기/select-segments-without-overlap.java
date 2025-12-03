import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Line> lines = new ArrayList<>();

        for(int i = 0; i<n;i++){
            lines.add(new Line(sc.nextInt(), sc.nextInt()));
        }

        lines.sort(null);
        
        int cnt = 0;
        int curEnd = 0;

        for(Line l: lines){
            if(curEnd<l.start){
                cnt++;
                curEnd = l.end;
            }
        }
        System.out.println(cnt);
        
    }

}
    class Line implements Comparable<Line>{
        int start;
        int end;

        Line(int s, int e){
            start = s;
            end = e;
        }

        @Override
        public int compareTo(Line o){
            return this.end - o.end;
        }
    }