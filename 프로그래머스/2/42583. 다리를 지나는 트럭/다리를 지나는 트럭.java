import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int truck_weigth = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int truck: truck_weights) {
            
            while(true) {
                if(queue.isEmpty()) { // 다리가 비어있는 경우
                    queue.offer(truck);
                    time++;
                    truck_weigth += truck;
                    break; // 다음 트럭으로 변경, 마지막 트럭인 경우 queue에 올라가고 반복문 종료
                } else if(queue.size() == bridge_length) { // 다리가 꽉 차 있는 경우
                    truck_weigth -= queue.poll();
                } else { // 다리가 비어있지 않지만 자리가 있는 경우
                    if(truck_weigth + truck <= weight) { // 다리에 다음 트럭을 올릴 수 있는 경우
                        queue.offer(truck);
                        time++;
                        truck_weigth += truck;
                        break; // 다음 트럭으로 변경
                    } else { // 다음 트럭을 올릴 수 없는 경우
                        queue.offer(0);
                        time++;
                    }
                    
                }
            }
        }       
        
        return time + bridge_length; // 마지막 트럭이 다리에서 지나가는 시간을 고려
    }
}