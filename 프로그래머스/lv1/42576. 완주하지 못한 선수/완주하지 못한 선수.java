import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for(String part : participant){
            map.put(part, map.getOrDefault(part, 0)+1);
        }
        for(String comple : completion){
            map.put(comple, map.get(comple)-1);
        }
        
        Iterator<Map.Entry<String,Integer>> iter = map.entrySet().iterator();  
        
        while(iter.hasNext()){
            Map.Entry<String,Integer> entry = (Map.Entry<String,Integer>) iter.next();
            if(entry.getValue()!=0){
                answer = entry.getKey();  
            }
        }
        return answer;
    }
}