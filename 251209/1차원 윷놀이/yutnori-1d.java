import java.util.*;
public class Main {

    public static int n;
    public static int m;
    public static int k;
    public static int[] nums;
    public static int[] horses;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt()-1;
        k = sc.nextInt();
        nums = new int[n];
        horses = new int[k];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        iter(0);
        System.out.println(maxCnt);
    }

    public static int maxCnt = 0;

    public static void iter(int it){
        if(it==n){
            int cnt = 0;
            for(int i: horses){
                if( i>=m) cnt++;
            }
            maxCnt = Math.max(maxCnt, cnt);
            return;
        }
        for(int i = 0; i<k;i++){
            if(horses[i]<m){
                horses[i]+=nums[it];
                iter(it+1);
                horses[i]-=nums[it];
            }
        }
    }


}