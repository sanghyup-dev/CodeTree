import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String s1 = sc.next();
    System.out.println(
        s1.charAt(0) + "a" + s1.substring(2, s1.length() - 2) + "a" + s1.charAt(s1.length() - 1));
  }
}