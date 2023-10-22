class Solution {
    public int solution(int[][] sizes) {
        int max_width = 0;
        int max_height = 0;
        
        for(int i=0; i<sizes.length; i++) {
            int width = Math.max(sizes[i][0], sizes[i][1]); // 두변 중 긴 부분
            int height = Math.min(sizes[i][0], sizes[i][1]); // 두변 중 짧은 부분
            max_width = Math.max(max_width, width);
            max_height = Math.max(max_height, height);
        }
        
        
        return max_width * max_height;
    }
}