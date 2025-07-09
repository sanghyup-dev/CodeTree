import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    for (int i = N; i < N * 5 + 1; i += N) {
      System.out.print(i + " ");
    }
  }
}