class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            boolean skip = false;
            if ((s.charAt(start) < 'a' || s.charAt(start) > 'z') &&
                (s.charAt(start) < '0' || s.charAt(start) > '9')) {
                start++;
                skip = true;
            }
            if ((s.charAt(end) < 'a' || s.charAt(end) > 'z') &&
                (s.charAt(end) < '0' || s.charAt(end) > '9')) {
                end--;
                skip = true;
            }
            if(skip){
                continue;
            }
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
}
