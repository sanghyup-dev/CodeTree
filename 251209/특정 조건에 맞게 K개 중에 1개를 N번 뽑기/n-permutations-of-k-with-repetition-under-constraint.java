import java.util.*;
public class Main {

    public static int n;
    public static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        iteration(0,-1,-1);
    }

    public static List<Integer> nums = new ArrayList<>();

    public static void iteration(int it, int prev, int prevprev){
        if(it==n){
            for(int i: nums){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=k; i++){
            if(i == prev && i == prevprev) continue;
            nums.add(i);
            iteration(it+1, i, prev);
            nums.remove(nums.size()-1);
        }
    }
}