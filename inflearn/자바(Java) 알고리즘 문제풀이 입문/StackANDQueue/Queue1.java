package inflearn.StackANDQueue;

import java.util.*;

// 5-6. 공주 구하기
public class Queue1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(new Queue1().solution(n, k));
    }

    public int solution(int n, int k){
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=n; i++) queue.offer(i); // add는 큐가 꽉찬 경우 예외를 발생, offer은 false를 리턴

        while(queue.size() > 1){
            for(int i=1; i<k; i++){ // k-1만큼 poll하고 offer
                queue.offer(queue.poll()); // poll은 꺼낸 값을 return하는 메소드
            }
            queue.poll(); // k일땐 그냥 poll
        }

        answer = queue.poll(); // 마지막 1개

        return answer;
    }
}
