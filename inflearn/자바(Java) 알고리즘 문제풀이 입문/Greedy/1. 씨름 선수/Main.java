import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Person implements Comparable<Person> {
    int h;
    int w;

    public Person(int h, int w) {
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Person o) {
        return o.h - this.h; // 키를 기준으로 '내림차순' 정렬
    }
}

public class Main {
    private static List<Person> persons;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        persons = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            persons.add(new Person(h, w));
        }
        Collections.sort(persons);
        int answer = solution();
        System.out.println(answer);
    }

    private static int solution() {
        int maxWeight = Integer.MIN_VALUE;
        int answer = 0;

        for (Person p : persons) {
            if (p.w > maxWeight) {
                answer++;
                maxWeight = p.w;
            }
        }

        return answer;
    }
}
