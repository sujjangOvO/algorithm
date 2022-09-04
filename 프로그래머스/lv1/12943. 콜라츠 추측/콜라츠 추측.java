class Solution {
    public int solution(long num) {
        int answer = 0; // cnt 

        if(num == 1) return 0;
        
        long temp = num;  // 오버플로우 때문에 long 타입으로 변환
        while(num != 1){
            
            if(temp % 2 == 0){
                num /= 2;
            }
            else{
                num *= 3;
                num += 1;
            }
            
            
            answer += 1;
            temp = num;
            
            if(answer > 499) return -1;
        }
        
        return answer;
    }
}