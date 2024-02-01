import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 8. 송아지 찾기 1(BFS : 상태트리탐색)
public class Main {
    public static int[] dis = {-1, 1, 5};
    public static int[] ch; // 이미 지난 지점을 확인하는 용도 (중복 제거)

    public static int bfs(int s, int e) {
        ch = new int[10001]; // 좌표는 1부터 10000이므로 10001크기
        Queue<Integer> Q = new LinkedList<>();

        // 출발지점 s를 체크 및 레벨 초기화
        ch[s] = 1;
        int level = 0;
        Q.offer(s);

        while (!Q.isEmpty()) {
            int size = Q.size(); // 중요!! 이렇게 변수로 빼두어야 35번째 줄에서 원소가 추가되어도 단게별 계산이 가능해진다!!

            for (int i = 0; i < size; i++) { // i<Q.size()는 불가능하다. 왜냐하면 35번째줄에서 원소가 계속 추가되기 때문에 Q.size()가 계속해서 변한다
                int x = Q.poll();

                for (int di : dis) {
                    int nx = x + di;

                    if (nx == e) {
                        return level + 1;
                    }

                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) { // 좌표값이며 가본적 없는 nx일때
                        Q.offer(nx);
                        ch[nx] = 1;
                    }
                }
            }
            level++;
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int s = Integer.parseInt(str[0]);
        int e = Integer.parseInt(str[1]);
        int answer = bfs(s, e);
        System.out.println(answer);
        br.close();
    }
}
