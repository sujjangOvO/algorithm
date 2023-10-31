class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        
        while(n >= a) { // a개 미만이 되면 빈 병을 받을 수 없으므로 빈병이 a개까지 작동한다
            int given = (n / a) * b; // 가게로부터 받을 수 있는 빈 병
            answer += given;  
            n = given + (n % a); // (n%a)는 가게에 내고 남은 빈 병
        }
        
        return answer;
    }
}