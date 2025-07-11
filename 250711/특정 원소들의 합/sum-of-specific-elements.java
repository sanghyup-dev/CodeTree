import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int cnt = 0;

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        if (j <= i) {
          cnt += sc.nextInt();
        } else {
          sc.nextInt();
        }
      }
    }
    System.out.println(cnt);
  }
}