class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int max_index = t.length() - p.length() + 1;
        int pLen = p.length();
        Long pNum = Long.parseLong(p);
        
        for(int i = 0; i < max_index; i++) {
            String temp = t.substring(i, i + pLen);
            
            if(pNum >= Long.parseLong(temp)) answer++;
        }
        
        return answer;
    }
}