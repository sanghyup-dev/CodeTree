import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.print(a + " " + b + " ");

    for (int i = 0; i < 8; i++) {
      int tmp = b;
      b = (a + b) % 10;
      a = tmp;
      System.out.print(b + " ");
    }
  }
}