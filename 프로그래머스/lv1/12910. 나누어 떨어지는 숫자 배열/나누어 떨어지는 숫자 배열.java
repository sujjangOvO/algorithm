import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>();
        boolean check = false;
        
        for(int element : arr){
            if(element < divisor) continue;
            if(element % divisor == 0){
                temp.add(element);
                
                if(!check) check = true;
            }
        }
        
        if(!check){
            answer = new int[1];
            answer[0] = -1;
        }
        else{
            Collections.sort(temp);
            answer = temp.stream().mapToInt(i->i).toArray();
        }
        
        return answer;
    }
}