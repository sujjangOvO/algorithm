import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> temp = new ArrayList<>();
        // boolean check = false;
        
        for(int element : arr){
            if(element < divisor) continue;
            if(element % divisor == 0){
                temp.add(element);
                
                // if(!check) check = true;
            }
        }
        
        //if(!check){
        if(temp.size() == 0) {
            answer = new int[] {-1};
        }
        else{
            answer = temp.stream().mapToInt(i->i).toArray();
            Arrays.sort(answer);
        }
        
        return answer;
    }
}