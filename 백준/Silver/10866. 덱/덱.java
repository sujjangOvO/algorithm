import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    public static int[] deque = new int[10001];
    public static int front, last, size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            switch (st.nextToken()) {
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    sb.append(pop_front() + "\n");
                    break;

                case "pop_back":
                    sb.append(pop_back() + "\n");
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

    public static void push_front(int value) { // 앞쪽으로 데이터 삽입 <-
        deque[front] = value;
        front = (front - 1 + deque.length) % deque.length; // 덱 길이만큼 더해주는 이유: 음수 방지
        size++;
    }

    public static void push_back(int value) { // 뒤쪽으로 데이터 삽입 ->
        last = (last + 1) % deque.length;
        deque[last] = value;
        size++;
    }

    public static int pop_front() { // 뒤쪽으로 데이터 제거 ->
        if (size == 0) {
            return -1;
        } else {
            int val = deque[(front + 1) % deque.length]; // front는 +1을 해주어야 현재 front임
            front = (front + 1) % deque.length;
            size--;
            return val;
        }
    }

    public static int pop_back() { // 앞쪽으로 데이터 제거 <-
        if (size == 0) {
            return -1;
        } else {
            int val = deque[last];
            last = (last - 1 + deque.length) % deque.length;
            size--;
            return val;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return (size == 0) ? 1 : 0;
    }

    public static int front() {
        return (size == 0) ? -1 : deque[(front + 1) % deque.length];
    }

    public static int back() {
        return (size == 0) ? -1 : deque[last];
    }
}
