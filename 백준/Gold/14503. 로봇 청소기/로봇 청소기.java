import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
		int[] dy = {0, 1, 0, -1};

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] room = new int[n][m];
		int count = 0;

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < m; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = true;

		while (flag) {
			if (room[r][c] == 0) {
				count++;
				room[r][c] = 2;
			}

			boolean move = false;

			for (int i = 0; i < 4; i++) { // 4칸중 청소되지 않은 빈칸이 있는 경우를 확인한다.
				int nx = r + dx[i];
				int ny = c + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
					move = true; // 청소되지 않은 빈칸으로 이동 가능
					break;
				}
			}

			if (move) { // 4칸중 청소되지 않은 빈칸이 있는 경우
				d = (d + 3) % 4; // 반시계 방향으로 회전 (원래 방향 변화)
				int nx = r + dx[d];
				int ny = c + dy[d];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && room[nx][ny] == 0) {
					r = nx;
					c = ny;
				}
			} else { // 4칸중 청소되지 않은 빈칸이 없는 경우
				int bd = (d + 2) % 4; // 후진 방향으로 좌표를 구하는 용도, 원래의 방향은 변화시키지 않는다.
				int bx = r + dx[bd];
				int by = c + dy[bd];

				if (bx >= 0 && bx < n && by >= 0 && by < m && room[bx][by] != 1) { // 벽이 아닐 때만 이동하면 된다. 이미 청소했어도 후진 가능!!
					r = bx;
					c = by;
				} else {
					flag = false; // 후진할 수 없다면 종료
				}
			}
		}

		System.out.println(count);
	}
}
