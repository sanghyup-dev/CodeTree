import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static int getdigit(int num, int ord) {
    int eraseLeft = num % (int) (Math.pow(10, ord));
    if (ord == 1) {
      return eraseLeft;
    }
    return eraseLeft / (int) (Math.pow(10, ord - 1));
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    List<Integer> arr = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      arr.add(sc.nextInt());
    }
    LinkedList<Integer>[] sifter = new LinkedList[10];

    for (int i = 1; i < 7; i++) {
      for (int j = 0; j < 10; j++) {
        sifter[j] = new LinkedList<>();
      }
      for (int j = 0; j < n; j++) {
        sifter[getdigit(arr.get(j), i)].add(arr.get(j));
      }
      List<Integer> newarr = new ArrayList<>();

      for (int j = 0; j < 10; j++) {
        for (Integer integer : sifter[j]) {
          newarr.add(integer);
        }
      }
      arr = newarr;
    }
    for (Integer i : arr) {
      System.out.print(i + " ");
    }
  }
}