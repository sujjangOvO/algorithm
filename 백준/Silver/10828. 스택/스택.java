import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        stack = new int[n];

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

                case "top":
                    sb.append(top() + "\n");
                    break;
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void push(int n) {
        stack[size++] = n;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        } else {
            int popValue = stack[size-1];
            stack[size-1] = 0;
            size--;
            return popValue;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return (size == 0) ? 1 : 0;
    }

    public static int top() {
        return (size ==  0) ? -1 : stack[size-1];
    }
}
