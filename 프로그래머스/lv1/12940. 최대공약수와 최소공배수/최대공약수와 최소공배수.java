class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = getGCD(n,m);
        answer[1] = (n * m) / (answer[0]);
        
        return answer;
    }
    
    public static int getGCD(int n, int m){
        if(n % m == 0){
            return m;
        }
        return getGCD(m,(n%m));
    }
}