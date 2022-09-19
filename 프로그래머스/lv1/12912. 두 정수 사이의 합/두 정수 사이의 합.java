class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        long x = Math.min(a,b);
        long y = Math.max(a,b);
        
        answer = (y-x+1) * (x+y) / 2; // 등차수열의합 공식
        
        /*
        if(a<b){
            for(int i=a; i<=b; i++){
                answer += (long)i;
            }
        }
        else{
            for(int i=b; i<=a; i++){
                answer += (long)i;
            }
        } */
        
        return answer;
    }
}