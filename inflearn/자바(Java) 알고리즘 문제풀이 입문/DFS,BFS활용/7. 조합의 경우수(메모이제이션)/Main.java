import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        // 강사님은 문제에 주어진 n과 r의 크기가 크지않아 [35][35] 크기로 하셨는데 어차피 빈 공간일 것 같아 주어진 n과 r로 할당함 
        memory = new int[n+1][r+1]; // 1번 인덱스부터 사용하기 때문에 한 사이즈크게 설정
        System.out.println(DFS(n, r));
    }

    private static int DFS(int n, int r) {
        if (memory[n][r] > 0) return memory[n][r]; // 이미 기록된 값이 있다면 재귀를 돌지않고 해당 값을 return
        if (r == 0 || n == r) return 1; // nC0은 무조건 1이고 2C2, 3C1같은 경우도 무조건 1이니 1을 return
        else {
            memory[n][r] = DFS(n - 1, r - 1) + DFS(n - 1, r); // 재귀를 통해 아래 값을 구해오고 메모리에 저장
            return memory[n][r]; // 메모리에 저장된 값을 return
        }
    }
}
