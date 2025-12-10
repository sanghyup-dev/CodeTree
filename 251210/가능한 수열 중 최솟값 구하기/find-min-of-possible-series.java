import java.util.*;

public class Main {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        iterate(0);
    }

    public static int last4 = -1;
    public static int last5 = -1;
    public static int last6 = -1;

    public static List<Integer> number = new ArrayList<>();

    public static boolean checkCanNext(int candidate, int cur){
        int prev = getLast(candidate);
        if(prev==-1) return true;
        if(prev==cur-1) return false;
        if(cur-prev>prev+1) return true;
        for(int i = 1; i<cur-prev;i++){
            if(number.get(cur-i)!=number.get(prev-i)) return true;
        }
        return false;
    }

    public static int getLast(int n){
        switch(n){
            case 4: return last4;
            case 5: return last5;
            case 6: return last6;
        }
        return -1;
    }

    public static void iterate(int it){
        if(it==n){
            for(int i: number){
                System.out.print(i);
            }
            System.exit(0);
        }
        for(int i = 4; i<=6;i++){
            if(checkCanNext(i, it)){
                number.add(i);
                int tmp = getLast(i);
                if(i==4) last4 = it;
                if(i==5) last5 = it;
                if(i==6) last6 = it;

                iterate(it+1);

                if(i==4) last4 = tmp;
                if(i==5) last5 = tmp;
                if(i==6) last6 = tmp;
                number.remove(number.size()-1);
            }
        }
    }
}