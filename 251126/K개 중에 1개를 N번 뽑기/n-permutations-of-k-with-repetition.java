import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        permutation(n,k,0);
    }
    
    private static List<Integer> numbers = new ArrayList<>();

    public static void permutation(int n, int k, int it){
        if(it == n){
            for(int i: numbers){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i<=k;i++){
            numbers.add(i);
            permutation(n,k,it+1);
            numbers.remove(numbers.size()-1);
        }
    }
}