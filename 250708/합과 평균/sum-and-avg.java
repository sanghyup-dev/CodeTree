import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.print(a + b + " ");
    System.out.printf("%.1f", (a + b) / 2.0);
  }
}