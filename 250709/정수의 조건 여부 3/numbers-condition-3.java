import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int aM = sc.nextInt();

    if (aM % 13 == 0 || aM % 19 == 0) {
      System.out.println("True");
    } else {
      System.out.println("False");
    }
  }
}