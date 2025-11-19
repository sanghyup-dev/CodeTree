import java.util.Scanner;
public class Main {
    public static int n;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        findJumps(0,0,arr);

        System.out.println(min==Integer.MAX_VALUE?-1:min);
    }


    private static void findJumps(int place, int it, int[] arr){
        if(n-1<=place){
            min = Math.min(min, it);
            return;
        }
        
        for(int i =1; i<=arr[place]; i++){
            findJumps(place+i, it+1, arr);
        }
    }


}