import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] strs = br.readLine().split(" ");

            for (String str : strs) {
                StringBuilder sb = new StringBuilder(str); // 1. StringBuilder의 reverse함수 사용
                System.out.print(sb.reverse() + " ");
            }

            System.out.println();
        }

        br.close();
    }
}
