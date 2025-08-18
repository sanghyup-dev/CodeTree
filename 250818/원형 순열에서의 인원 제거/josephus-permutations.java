import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {

  public static int iter(Queue<Integer> q, int k) {
    for (int i = 0; i < k - 1; i++) {
      q.add(q.poll());
    }
    return q.poll();
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    Queue<Integer> q = new ArrayDeque<>();
    for (int i = 1; i <= n; i++) {
      q.add(i);
    }
    for (int i = 0; i < n; i++) {
      System.out.print(iter(q, k) + " ");
    }
  }
}