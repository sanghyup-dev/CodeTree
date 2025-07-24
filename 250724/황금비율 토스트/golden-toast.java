import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int m = sc.nextInt();
    String s = sc.next();
    sc.nextLine();
    List<Character> list = new LinkedList<>();
    ListIterator<Character> it = list.listIterator();
    for (int i = 0; i < s.length(); i++) {
      it.add(s.charAt(i));
    }

    for (int i = 0; i < m; i++) {
      String command = sc.next();
      if (command.equals("L")) {
        if (it.hasPrevious()) {
          it.previous();
        }
      }
      if (command.equals("R")) {
        if (it.hasNext()) {
          it.next();
        }
      }
      if (command.equals("D")) {
        if (it.hasNext()) {
          it.next();
          it.remove();
        }
      }
      if (command.equals("P")) {
        it.add(sc.next().charAt(0));
      }
    }
    for (char c : list) {
      System.out.print(c);
    }
  }
}