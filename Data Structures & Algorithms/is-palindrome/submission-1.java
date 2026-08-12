class Solution {
    private boolean isNotValidChar(char ch) {
        if(ch >= 'a' && ch <= 'z') return false;
        if(ch >= 'A' && ch <= 'Z') return false;
        if(ch >= '0' && ch <= '9') return false;

        return true;
    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        int n = s.length();

        int left = 0, right = n-1;

        while(left <= right) {

            if(isNotValidChar(s.charAt(left))) {
                left++;
                continue;
            }

            if(isNotValidChar(s.charAt(right))) {
                right--;
                continue;
            }

            if(s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }

        return true;
    }
}
