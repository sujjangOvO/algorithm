class Solution {
    public long solution(long n) {

        long sqr = (long)(Math.sqrt(n));
        long p = (long)Math.pow(sqr,2);
        
        return (p == n)? (long)Math.pow(sqr+1,2) : -1;

    }  
}