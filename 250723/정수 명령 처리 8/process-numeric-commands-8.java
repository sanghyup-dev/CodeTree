import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 명령의 수
        sc.nextLine();         // 개행 문자 제거

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String[] cmd = sc.nextLine().split(" ");

            switch (cmd[0]) {
                case "push_front":
                    list.addFirst(Integer.parseInt(cmd[1]));
                    break;

                case "push_back":
                    list.addLast(Integer.parseInt(cmd[1]));
                    break;

                case "pop_front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.removeFirst());
                    }
                    break;

                case "pop_back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.removeLast());
                    }
                    break;

                case "size":
                    System.out.println(list.size());
                    break;

                case "empty":
                    System.out.println(list.isEmpty() ? 1 : 0);
                    break;

                case "front":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.getFirst());
                    }
                    break;

                case "back":
                    if (list.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(list.getLast());
                    }
                    break;
            }
        }

        sc.close();
    }
}
