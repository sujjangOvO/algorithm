class Solution {
    public String solution(int a, int b) {
        String[] days = {"FRI","SAT","SUN","MON","TUE","WED","THU"}; // 1월1일은 금요일
        String answer="";
        int[] months ={31,29,31,30,31,30,31,31,30,31,30,31};
        
        int total = 0;
        for(int i=0; i<a-1; i++){
            total += months[i];
        }
        total += (b-1) ; // 1월 1일이 포함되어 있으므로 하루 제거
        
        answer = days[total%7];
        return answer;
    }
}