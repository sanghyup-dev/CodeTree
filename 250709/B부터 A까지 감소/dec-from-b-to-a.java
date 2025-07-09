import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int B = sc.nextInt();
    for (int i = N; i >= B; i--) {
      System.out.print(i + " ");
    }
  }
}