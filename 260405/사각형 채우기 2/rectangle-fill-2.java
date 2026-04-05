import java.util.*;

public class Main {

    public static int findNofPossibilities(int n){
        if (n==0 || n==1) return 1;
        return (findNofPossibilities(n-1) + findNofPossibilities(n-2)*2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(findNofPossibilities(sc.nextInt()));
    }
}
