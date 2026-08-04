class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length(), n = t.length();

        int[] alphabets = new int[32];

        if(m != n) return false;

        int total = 0;

        for(int i=0 ; i<m ; i++) {
            int idx = s.charAt(i) - 'a';
            alphabets[idx]++;
            total++;
        }

        for(int i=0 ; i<n ; i++) {
            int idx = t.charAt(i) - 'a';
            if(alphabets[idx] != 0) {
                alphabets[idx]--;
                total--;
            }
        }

        return total == 0;
    }
}
