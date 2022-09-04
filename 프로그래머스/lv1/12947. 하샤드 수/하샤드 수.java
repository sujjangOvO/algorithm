class Solution {
    public boolean solution(int x) {
        int original_x = x;
        int digit_sum = 0;
        while(x > 0){
            digit_sum += (x % 10);
            x /= 10;
        }
        
        return original_x % digit_sum == 0;
        // return (original_x % digit_sum == 0) ? true : false;
        // 굳이 삼항안써도됨
        
    }
}