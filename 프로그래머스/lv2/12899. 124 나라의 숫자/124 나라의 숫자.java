class Solution {
    
    public static String numbers[] = {"4","1","2"};
    
    public String solution(int n) {
        String answer = "";
        
        while(n>0){
            if(n%3 != 0){
                answer = numbers[n%3] + answer;
            }
            else{
                answer = numbers[0] + answer;
                n -= 1;
            }
            n /= 3;
        }
        
        return answer;
    }
}