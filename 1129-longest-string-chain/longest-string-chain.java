class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;
        Arrays.sort(words,(a,b)->
        {
            return Integer.compare(a.length(),b.length());
        });
        int dp[]=new int[n];
        Arrays.fill(dp,1);
        int ans=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(isvalid(words[i],words[j]) && dp[j]+1>dp[i])
                {
                    dp[i]=dp[j]+1;
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
    public boolean isvalid(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1)
        {
            return false;
        }
        int idx1=0,idx2=0;
        while(idx1<s1.length())
        {
            if(idx2!=s2.length() && s1.charAt(idx1)==s2.charAt(idx2))
            {
                idx1++;
                idx2++;
            }
            else
            {
                idx1++;
            }
        }
        if(idx2==s2.length())
        {
            return true;
        }
        return false;
    }
}