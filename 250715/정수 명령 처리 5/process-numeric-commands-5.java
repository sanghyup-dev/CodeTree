import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 명령 개수
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String cmd = sc.next();

            if (cmd.equals("push_back")) {
                int val = sc.nextInt();
                list.add(val);
            } else if (cmd.equals("pop_back")) {
                list.remove(list.size() - 1);
            } else if (cmd.equals("size")) {
                System.out.println(list.size());
            } else if (cmd.equals("get")) {
                int k = sc.nextInt();
                System.out.println(list.get(k - 1));
            }
        }
    }
}
