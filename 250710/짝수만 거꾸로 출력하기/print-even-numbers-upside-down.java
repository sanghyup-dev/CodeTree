import java.util.ArrayList;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    ArrayList<Integer> ls = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int num = sc.nextInt();
      if (num % 2 == 0) {
        ls.add(num);
      }
    }

    for (int i = ls.size() - 1; i >= 0; i--) {
      System.out.print(ls.get(i) + " ");
    }

  }
}