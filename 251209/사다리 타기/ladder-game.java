import java.util.*;
public class Main {

    public static int n;
    public static int m;
    public static List<Line> lines;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lines = new ArrayList<>();
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            lines.add(new Line(a,b));
        }
        lines.sort((x,y)-> x.row-y.row);
        answer = ladderResult(lines);
        permutate(0,0);
        System.out.println(MinCnt);
    }

    public static List<Integer> answer;

    public static int MinCnt = Integer.MAX_VALUE;

    public static List<Line> selected = new ArrayList<>();

    public static void permutate(int it, int cnt){
        if(it==m){
            if(answer.equals(ladderResult(selected))){
                MinCnt = Math.min(MinCnt, cnt);
            }
            return;
        }
        permutate(it+1, cnt);
        selected.add(lines.get(it));
        permutate(it+1,cnt+1);
        selected.remove(selected.size()-1);
    }

    public static List<Integer> ladderResult(List<Line> lines){
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            result.add(i);
        }
        for(Line line: lines){
            swap(result, line.col-1, line.col);
        }
        return result;
    }

    public static void swap(List<Integer> order, int i, int j){
        int tmp = order.get(i);
        order.set(i, order.get(j));
        order.set(j, tmp);
    }


    public static class Line{
        int col;
        int row;

        Line(int col,int row){
            this.col = col;
            this.row = row;
        }
    }
}