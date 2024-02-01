import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int k = Integer.parseInt(str[1]);

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=n; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            for(int i=1; i<=k; i++) {
                if(i==k) {
                    sb.append(queue.poll()).append(", ");
                } else {
                    int value = queue.poll();
                    queue.offer(value);
                }
            }
        }

        sb.append(queue.poll()).append(">");
        System.out.println(sb);
        br.close();
    }
}
