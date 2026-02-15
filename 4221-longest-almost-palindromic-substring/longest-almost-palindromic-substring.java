class Solution {

    private int getPalidromeLen(String s, int l, int r, boolean skip) {
        if (l < 0 && r >= s.length()) return 0;
        if (l < 0 || r >= s.length()) return skip ? 1 : 0; 

        if (s.charAt(l) == s.charAt(r)) {
            int matchCount = (l == r) ? 1 : 2;
            return matchCount + getPalidromeLen(s, l - 1, r + 1, skip);
        } 
        
        if (skip) {
            return 1 + Math.max(
                getPalidromeLen(s, l - 1, r, false), 
                getPalidromeLen(s, l, r + 1, false)
            );
        }

        return 0;
    }
    
    public int almostPalindromic(String s) {
        int res = 2;
        for(int i=0; i<s.length(); i++) {
            res = Math.max(res, getPalidromeLen(s, i, i, true));
            res = Math.max(res, getPalidromeLen(s, i, i+1, true));
        }
        return res;
    }
}
