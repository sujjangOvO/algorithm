import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static PriorityQueue<Integer> q;
    static int[] priorities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]); // 1 <= n <= 100
            int m = Integer.parseInt(s[1]); // 0 <= m < n
            priorities = new int[n];

            String[] numbers = br.readLine().split(" ");
            for(int j=0; j<n; j++) {
                priorities[j] = Integer.parseInt(numbers[j]);
            }

            q = new PriorityQueue<>(Collections.reverseOrder());
            for(int p : priorities) {
                q.offer(p);
            }

            System.out.println(solve(n, m));
        }

        br.close();
    }

    public static int solve(int n, int m) {
        int answer = 0;

        while(!q.isEmpty()) {
            for(int j=0; j<n; j++) {
                if(q.peek() == priorities[j]) {
                    answer++;
                    q.poll();

                    if(j == m) {
                        q.poll();
                        return answer;
                    }
                }
            }
        }

        return answer;
    }
}
