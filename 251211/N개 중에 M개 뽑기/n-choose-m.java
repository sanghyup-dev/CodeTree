import java.util.*;

public class Main {

    public static int n;
    public static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        printPermutation(0,0);
    }

    public static List<Integer> nums = new ArrayList<>();

    public static void printPermutation(int cnt, int cur){
        if(cnt==m){
            for(int n: nums){
                System.out.print(n+" ");
            }
            System.out.println();
            return;
        }

        for(int i = cur+1; i<=n; i++){
            nums.add(i);
            printPermutation(cnt+1, i);
            nums.remove(nums.size()-1);
        }

    }
}