import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s1 = sc.next();
    String s2 = sc.next();

    if (s1.length() > s2.length()) {
      s2 = s1;
    } else if (s1.length() == s2.length()) {
      System.out.println("same");
      return;
    }
    System.out.println(s2 +" "+ s2.length());
  }
}