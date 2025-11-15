import java.util.*;

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static List<Integer> candidates = new ArrayList<>();

    public static void backtracking(int length, String expression){
        if(length==7){
            max = Math.max(max, calculate(expression, candidates));
            return;
        }
        for(int i = 1; i<5;i++){
            candidates.add(i);
            backtracking(length+1,expression);
            candidates.remove(candidates.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.next();
        backtracking(0,expression);
        System.out.println(max);
    }

    public static int calculate(String expression, List<Integer> variables){
        int ans = 0;
        for(int i = 0; i< expression.length(); i++){
            if(i==0) {
                ans = variables.get((int) (expression.charAt(i))- 'a');
                continue;
            }

            char c = expression.charAt(i);

            if(c=='+')ans += variables.get((int) (expression.charAt(++i))- 'a');
            if(c=='-')ans -= variables.get((int) (expression.charAt(++i))- 'a');
            if(c=='*')ans *= variables.get((int) (expression.charAt(++i))- 'a');
            
        }
        return ans;
    }
}