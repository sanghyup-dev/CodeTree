import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            if (line.startsWith("push")) {
                // "push A"
                int x = Integer.parseInt(line.substring(5));
                q.addLast(x);
            } else if ("pop".equals(line)) {
                out.append(q.removeFirst()).append('\n'); // 문제에서 불가능한 명령 없음 가정
            } else if ("size".equals(line)) {
                out.append(q.size()).append('\n');
            } else if ("empty".equals(line)) {
                out.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if ("front".equals(line)) {
                out.append(q.peekFirst()).append('\n');
            }
        }

        System.out.print(out);
    }
}
