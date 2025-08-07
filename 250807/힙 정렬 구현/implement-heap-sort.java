import java.util.Scanner;

public class Main {

  public static void heapify(int[] arr, int n, int i) {
    int largest = i;
    int l = i * 2;
    int r = i * 2 + 1;

    if (l <= n && arr[l] > arr[largest]) {
      largest = l;
    }
    if (r <= n && arr[r] > arr[largest]) {
      largest = r;
    }

    if (largest != i) {
      int tmp = arr[largest];
      arr[largest] = arr[i];
      arr[i] = tmp;
      heapify(arr, n, largest);
    }
  }

  public static void heapSort(int[] arr, int n) {
    for (int i = n / 2; i > 0; i--) {
      heapify(arr, n, i);
    }
    for (int i = n; i > 0; i--) {
      int tmp = arr[i];
      arr[i] = arr[1];
      arr[1] = tmp;
      n--;
      heapify(arr, n, 1);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n + 1];
    arr[0] = 0;
    for (int i = 1; i <= n; i++) {
      arr[i] = sc.nextInt();
    }
    heapSort(arr, n);

    for (int i = 1; i <= n; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}