import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int[] queue;
    public static int front, back = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queue = new int[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            switch (st.nextToken()) {
                case "push":
                    int value = Integer.valueOf(st.nextToken());
                    push(value);
                    break;

                case "pop":
                    sb.append(pop() + "\n");
                    break;

                case "size":
                    sb.append(size() + "\n");
                    break;

                case "empty":
                    sb.append(empty() + "\n");
                    break;

                case "front":
                    sb.append(front() + "\n");
                    break;

                case "back":
                    sb.append(back() + "\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void push(int value) {
        queue[back++] = value;
    }

    public static int pop() {
        if(front == back) {
            return -1;
        } else {
            return queue[front++];
        }
    }

    public static int size() {
        return back - front;
    }

    public static int empty() {
        return (front == back) ? 1 : 0;
    }

    public static int front() {
        return (front == back) ? -1 : queue[front];
    }

    public static int back() {
        return (front == back) ? -1 : queue[back-1];
    }
}
