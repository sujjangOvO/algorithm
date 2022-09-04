import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] words = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        int[] integers = {0,1,2,3,4,5,6,7,8,9};
        
        StringBuffer sb = new StringBuffer();
        ArrayList<Integer> temp = new ArrayList<>(); // answer로 바꿀 list
        String[] s_array = s.split("");
        
        for(String string : s_array){

            try{
                int k = Integer.parseInt(string);
                temp.add(k); // 숫자라면 temp에 추가
                continue;
                
            }
            catch(NumberFormatException e){
                // 숫자가 아니라면 그냥 넘어감
            }
            
            sb.append(string);
            
            if(Arrays.asList(words).contains(sb.toString())){
                temp.add(Arrays.asList(words).indexOf(sb.toString()));
                sb.setLength(0);   // StringBuffer 초기화
            }  
            
        } 
        
        
        for(int i=0; i<temp.size(); i++){
            answer *= 10;
            answer += temp.get(i);
        }
        
        return answer;
    }
}