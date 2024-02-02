import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            System.out.println(solve(str));
        }
        br.close();
    }

    private static String solve(String str) {
        Stack<Character> stack = new Stack<>();

        if (str.charAt(0) == ')') {
            return "NO";
        }

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) { // ')'가 많은 경우 빈 stack에서 pop시도 -> 예외 발생
                    return "NO";
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            return "YES"; // () 쌍이 올바르게 나오는 경우
        } else {
            return "NO"; // '('가 많은 경우 stack에 '('가 남아있게 된다
        }
    }
}
