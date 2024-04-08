import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time implements Comparable<Time> {
    int time;
    char status;

    public Time(int time, char status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public int compareTo(Time o) {
        if(o.time == this.time) {
            return this.status - o.status; // 오름차순, 시간이 같다면 'e'가 먼저 오도록 하자 (끝나서 나가는 사람을 먼저 count)
        } else {
            return this.time - o.time; // 내림차순, 먼저 도착하는 사람 순서대
        }
    }
}

public class Main {
    private static List<Time> times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        times = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            times.add(new Time(s, 's'));
            times.add(new Time(e, 'e'));
        }
        Collections.sort(times);
        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int answer = 0;
        int count = 0;

        for (Time time : times) {
            if (time.status == 's') {
                count++;
            }
            if(time.status == 'e') {
                count--;
            }

            answer = Math.max(answer, count);
        }

        return answer;
    }
}
