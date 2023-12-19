import java.util.Arrays;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        
        for(int i=0; i<photo.length; i++) {
            for(int j=0; j<photo[i].length; j++) {
                String personInPhoto = photo[i][j];
                
                int nameIndex = Arrays.asList(name).indexOf(personInPhoto);
                
                if(nameIndex != -1) {
                    answer[i] += yearning[nameIndex];
                }
            }
        }
        
        
        return answer;
    }
}