import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Time implements Comparable<Time> {
    int s;
    int e;

    public Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (o.e == this.e) {
            return this.s - o.s; // 끝나는 시간이 같다면 시작 시간 기준 '오름차순' 정렬
        } else {
            return this.e - o.e; // 끝나는 시간 기준 '오름차순' 정렬
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
            times.add(new Time(s, e));
        }
        Collections.sort(times);
        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int endTime = 0;
        int answer = 0;

        for (Time time : times) {
            if (time.s >= endTime) { // 현재 진행하는 회의의 끝나는 시간보다 시작 시간이 크거나 같다면 
                answer++; // 회의를 진행하고 
                endTime = time.e; // 진행하는 회의의 끝나는 시간을 endTime으로 설정해준다
            }
        }

        return answer;
    }
}
