class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);
        int l=0,r=0;
        int count=0;
        while(l<g.length && r<s.length)
        {
            if(g[l]<=s[r])
            {
                count++;
                l++;
            }
            r++;
        }
        return count;
    }
}