class Solution {
    public int maxDepth(String s) {
        int cnt=0;
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='(')
            {
                cnt++;
                ans=Math.max(ans,cnt);
            }
            else  if(x==')')
            {
                cnt--;
            }
        }
        return ans;
    }
}