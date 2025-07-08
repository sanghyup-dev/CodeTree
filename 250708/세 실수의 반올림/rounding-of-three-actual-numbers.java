import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int a = 3;
    while (a-- > 0) {
      System.out.printf("%.3f \n", sc.nextDouble());
    }
  }
}