import java.util.Scanner;

public class Main {

  public static void merge(int[] arr, int low, int mid, int high) {
    int k = low;
    int i = low;
    int j = mid + 1;

    while (i <= mid && j <= high) {
      if (arr[i] >= arr[j]) {
        merged[k] = arr[j];
        j++;
      } else {
        merged[k] = arr[i];
        i++;
      }
      k++;
    }
    while (i <= mid) {
      merged[k] = arr[i];
      i++;
      k++;
    }
    while (j <= high) {
      merged[k] = arr[j];
      j++;
      k++;
    }

    for (int l = low; l <= high; l++) {
      arr[l] = merged[l];
    }
  }

  public static void mergeSort(int[] arr, int low, int high) {
    int mid = (low + high) / 2;
    if (low < high) {
      mergeSort(arr, low, mid);
      mergeSort(arr, mid + 1, high);
      merge(arr, low, mid, high);
    }
  }

  public static int[] merged;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    merged = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    mergeSort(arr, 0, n - 1);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}