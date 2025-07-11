import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = 0;
    for (int i = 0; i < 16; i++) {
      if (sc.nextInt() % 5 == 0) {
        cnt++;
      }
    }
      System.out.println(cnt);
  }
}