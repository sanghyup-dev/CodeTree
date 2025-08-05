import java.util.Scanner;

public class Main {

  public static int seperate(int[] arr, int low, int high) {
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j] < arr[high]) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
        i++;
      }
    }
    int tmp = arr[i];
    arr[i] = arr[high];
    arr[high] = tmp;
    return i;
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int sep = seperate(arr, low, high);
      quickSort(arr, low, sep - 1);
      quickSort(arr, sep + 1, high);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    quickSort(arr, 0, n - 1);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}