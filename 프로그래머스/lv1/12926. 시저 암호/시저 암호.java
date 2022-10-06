class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int check = 0; // 0이면 소문자, 1이면 대문자
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ' ') {
                sb.append(" ");
                continue;
            }
            
            if(ch >= 65 && ch <=90) check = 1;
            else check = 0;
            
            ch += n;
            if(check == 0 && ch > 122){ // 소문자
                ch -= 26;
            }
            else if(check == 1 && ch > 90){ // 대문자
                ch -= 26;
            }
            
            sb.append(Character.toString(ch));
        }
        
        answer = sb.toString();
        return answer;
    }
}