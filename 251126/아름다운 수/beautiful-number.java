import java.util.*;
public class Main {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        findBeautyNum(0);
        System.out.println(cnt);
    }

    public static int cnt = 0;
    public static List<Integer> number = new ArrayList<>();

    public static void findBeautyNum(int it){
        if(it>n){
            return;
        }
        if(it==n){
            cnt++;
            return;
        }

        for(int i=1; i<=4;i++){
            for(int j = 0; j<i;j++){
                number.add(i);
            }
            findBeautyNum(it+i);
            for(int j = 0; j<i;j++){
                number.remove(number.size()-1);
            }
        }
    }
}