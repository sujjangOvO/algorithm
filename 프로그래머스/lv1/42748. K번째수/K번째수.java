import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i=0;
        int j=0;
        int k=0;
        
        for(int x=0; x<commands.length; x++){
            i = commands[x][0];
            j = commands[x][1];
            k = commands[x][2];
            
            int[] temp = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(temp);
            answer[x] = temp[k-1];
        }
        
        return answer;
    }
}