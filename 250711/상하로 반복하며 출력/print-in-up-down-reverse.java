import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[][] arr = new int[n][n];
    for (int i = 0; i < n; i++) {
      if (i % 2 == 0) {
        for (int j = 1; j <= n; j++) {
          arr[j - 1][i] = j;
        }
      } else {
        for (int j = n; j > 0; j--) {
          arr[j - 1][i] = n - j+1;
        }
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }


  }
}