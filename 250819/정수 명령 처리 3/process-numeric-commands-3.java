import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // number of commands
        sc.nextLine();          // consume newline

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();

            if (command.startsWith("push_front")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(x);
            } 
            else if (command.startsWith("push_back")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                deque.addLast(x);
            } 
            else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.removeFirst());
                }
            } 
            else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.removeLast());
                }
            } 
            else if (command.equals("size")) {
                System.out.println(deque.size());
            } 
            else if (command.equals("empty")) {
                System.out.println(deque.isEmpty() ? 1 : 0);
            } 
            else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            } 
            else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
