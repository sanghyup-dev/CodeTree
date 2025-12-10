import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static boolean found = false;   // 해답 찾으면 더 이상 탐색하지 않기 위해
    static String answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        dfs("");
        System.out.println(answer);
    }

    // 현재까지 만든 수열 s에서 계속 이어서 만든다
    private static void dfs(String s) {
        if (found) return; // 이미 답을 찾았으면 더 볼 필요 없음

        if (s.length() == N) {
            answer = s;
            found = true;
            return;
        }

        // 사전순 최소를 위해 4 -> 5 -> 6 순서로 시도
        for (char ch : new char[]{'4', '5', '6'}) {
            String next = s + ch;
            if (isGood(next)) {
                dfs(next);
                if (found) return;
            }
        }
    }

    // 인접한 두 부분 수열이 같은지 검사
    private static boolean isGood(String s) {
        int len = s.length();

        // 길이 l짜리 부분 수열 두 개가 인접하게 같으면 안 됨
        for (int l = 1; l * 2 <= len; l++) {
            String prev = s.substring(len - 2 * l, len - l);
            String last = s.substring(len - l, len);
            if (prev.equals(last)) {
                return false;  // 나쁜 수열
            }
        }

        return true; // 지금까지는 좋은 수열
    }
}
