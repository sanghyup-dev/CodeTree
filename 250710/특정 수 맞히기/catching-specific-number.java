import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    while (true) {
      int a = sc.nextInt();
      if (a > 25) {
        System.out.println("Good");
      } else if (a == 25) {
        System.out.println("Higher");
        break;
      } else {
        System.out.println("Lower");
      }
    }
  }
}