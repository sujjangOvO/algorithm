class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0; i<nums.length-2; i++) {
            int sum = 0;
            
            for(int j=i+1; j<nums.length-1; j++) {
                
                for(int p=j+1; p<nums.length; p++) {
                    sum = nums[i] + nums[j] + nums[p];
                    
                    boolean check = true;
                    for(int k=2; k<sum; k++) {
                        if(sum % k == 0) {
                            check = false;
                            break;
                        }
                    }

                    if(check) answer++;
                }

            }
        }
            
        return answer;
    }
}