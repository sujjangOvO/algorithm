class Solution {
    
    String[] alpha = {"a","b","c","d","e","f","g","h","i","j","k",
                    "l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    
    public boolean solution(String s) {
        boolean answer = true;

        
        if(s.length() != 4 && s.length() != 6){
            return false;
        }
        
        s = s.toLowerCase();
        
        for(int i=0; i<26; i++){
            if(s.contains(alpha[i])){
                return false;
            }
        }
        
        /*
        String[] s_arr = s.split("");
        java.util.Arrays.sort(s_arr);
        

        for(int i=s_arr.length-1; i>=0; i--){
            if(alpha.contains(s_arr[i])){
                return false;
            } 
        }
        */
        
        
        return answer;
    }
}