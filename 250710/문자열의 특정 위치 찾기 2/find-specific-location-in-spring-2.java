import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String[] slist = {"apple", "banana", "grape", "blueberry", "orange"};

    char toFind = sc.next().charAt(0);

    int cnt = 0;

    for (String s : slist) {
      if (toFind == s.charAt(2) || toFind == s.charAt(3)) {
        System.out.println(s);
        cnt++;
      }
    }
      System.out.println(cnt);
  }
}