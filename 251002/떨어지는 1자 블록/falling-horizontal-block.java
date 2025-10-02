import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt() - 1;
    int[][] grid = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        grid[i][j] = sc.nextInt();
      }
    }
    for (int i = 0; i < n; i++) {
      boolean isEnd = false;
      for (int j = k; j < k + m; j++) {
        if (i == n - 1 || grid[i + 1][j] == 1) {
          isEnd = true;
          break;
        }
      }
      if (isEnd) {
        for (int j = k; j < k + m; j++) {
          grid[i][j] = 1;
        }
        break;
      }
    }
    for (int[] ints : grid) {
      for (int i : ints) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}