class Solution {
    public int solution(String s) {
        int answer = 0;
        String str = Character.toString(s.charAt(0));
        
        if(str.equals("-")){
            s = s.substring(1,s.length());
            return Integer.parseInt(s) * -1 ;
        }
        else{
            return Integer.parseInt(s);
        }

    }
}