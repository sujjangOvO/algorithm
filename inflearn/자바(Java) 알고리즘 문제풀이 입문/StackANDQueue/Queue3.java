package inflearn.StackANDQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 5-8. 응급실
class Person{
    int id; // 순서
    int priority; // 위험도
    public Person(int id, int priority){
        this.id = id;
        this.priority = priority;
    }
}

public class Queue3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] risks = new int[n];
        for(int i=0; i<n; i++){
            risks[i] = scanner.nextInt();
        }
        System.out.println(new Queue3().solution(n, m, risks));
    }

    public int solution(int n, int m, int[] risks){
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for(int i=0; i<n; i++){
            q.offer(new Person(i, risks[i]));  // person 객체를 큐에 넣어줌
        }

        while(!q.isEmpty()){
            Person person = q.poll();

            for(Person p : q){
                if(p.priority > person.priority){  // 큐에 들어있는 객체의 우선순위를 전부 확인하고 person보다 큰게 있다면
                    q.offer(person); // person을 뒤로 넣는다
                    person = null;  // 46번쨰 if문에 걸리지 않게 => 진료받을 수 없는 상태의 사람임을 나타냄
                    break;
                }
            }

            if(person != null){ // 진료받을 수 있는 상태의 사람
                answer++;
                if(person.id == m) return answer;
            }
        }
        return answer;
    }
}
