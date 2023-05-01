package inflearn.StackANDQueue;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        String plan = scanner.next();
        System.out.println(new Queue2().solution(order, plan));
        System.out.println(new Queue2().solution2(order, plan));
    }

    public String solution2(String need, String plan){
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x : need.toCharArray()) Q.offer(x); // Q에 순서대로 필수과목을 넣는다

        for(char x : plan.toCharArray()){
            if(Q.contains(x)){
                if(x != Q.poll()) { // 맨앞의 자료와 다르다면 => 순서가 다르다
                    return "NO";
                }
            }
        }

        if(!Q.isEmpty()) return "NO";

        return answer;
    }

    public String solution(String order, String plan){
        String answer = "NO";
        int idx = 0;
        char[] order_arr = order.toCharArray();

        Queue<Character> q = new LinkedList<>();
        for(char x:plan.toCharArray()) q.offer(x);

        while(!q.isEmpty()){
            if(q.poll() == order_arr[idx]) {
                idx++;
                if(idx == order_arr.length) break;
            }
        }

        if(idx == order_arr.length) answer = "YES";

        return answer;
    }
}
