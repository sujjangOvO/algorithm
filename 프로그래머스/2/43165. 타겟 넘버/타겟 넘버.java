class Solution {
    
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, 0, numbers, target);
        return answer;
    }
    
    public void dfs(int n, int idx, int[] numbers, int target) {
        if(idx == numbers.length) {
            if(n == target) {
                answer++;
            } else {
                return;
            }
        } else {
            dfs(n + numbers[idx], idx+1, numbers, target);
            dfs(n - numbers[idx], idx+1,  numbers, target);
        }
    }
}