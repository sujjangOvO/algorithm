import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].charAt(n) + strings[i];
        }
        
        
        Arrays.sort(strings);
        
        
        // Arrays.sort(strings, new Comparator<String>() {
        //     @Override
        //     public int compare(String s1, String s2) {
        //         if(s1.charAt(n) > s2.charAt(n)) return 1;
        //         else if(s1.charAt(n) < s2.charAt(n)) return -1;
        //         else return 0;
        //     }
        // });
        
        for(int i=0; i<strings.length; i++) {
            strings[i] = strings[i].substring(1);
        }
        
        return strings;
    }
}