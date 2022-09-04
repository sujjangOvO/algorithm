import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int[] answer = {};
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int num = 0;
        for(int i=0; i<arr.length; i++){
            num = arr[i];
            
            if(list.isEmpty() || list.get(list.size()-1) != num){
                list.add(num);
            }
            
        }
        
        
        answer = new int[list.size()];
        int size = 0;
        for(int anw : list){
            answer[size++] = anw;
        }      
        return answer;
    }
}