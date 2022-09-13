class Solution {
    
    public double solution(int[] arr) {
        
        double answer=0;
        
        if(arr.length == 0 || arr == null){
            return 0;
        }
        
        if (arr.length<0||arr.length>100)
        {
            return 0;
        }
        
        for(int a:arr)
        {
            answer+=(double)a;
        }
        
        return answer/(double)arr.length;
    }
    
    public static void main(String[] args){
        int[] arr={1,2,3,4};
        Solution sol=new Solution();
        System.out.println(sol.solution(arr));
        
    }    
}