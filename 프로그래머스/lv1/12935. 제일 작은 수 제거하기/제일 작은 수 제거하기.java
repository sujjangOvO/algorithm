import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        
        
        int min_num = 999999999;
        int index = -1;
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            
            if(min_num > num){
                min_num = num;
                index = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            if(i == index) continue;
            else temp.add(arr[i]);
        }
        
        answer = temp.stream().mapToInt(i -> i).toArray();
        
        /*
        Arrays.sort(arr);
        
        for(int i = arr.length-1; i>0; i--){
            answer[arr.length - 1 - i] = arr[i];
        }
        */
        
        
        return answer;
    }
}