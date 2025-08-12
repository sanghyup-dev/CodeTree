import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (cnt > 0 && str.charAt(i) == ')') {
        cnt--;
      } else {
        cnt++;
      }
    }
    System.out.println(cnt == 0 ? "Yes" : "No");
  }
}