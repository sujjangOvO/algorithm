class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i=left; i<=right; i++){
            int sqrt = (int)Math.sqrt(i);
            int cnt = 0;
            
            for(int j=1; j<=sqrt; j++){
                if(i%j == 0){
                    cnt++;
                    if(i/j != j){
                        cnt++;
                    }
                }
            }

            if(cnt%2 != 0){
                answer -= i;
            }
            else{
                answer += i;
            }
        }

        return answer;
    }
}