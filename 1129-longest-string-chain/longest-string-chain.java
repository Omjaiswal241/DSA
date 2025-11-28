class Solution {
    public int longestStrChain(String[] words) {
     Arrays.sort(words,(a,b)->(a.length()-b.length()));
     int n=words.length;
     int dp[]=new int[n];
     Arrays.fill(dp,1);
     int max=1;
     for(int i=1;i<n;i++)
     {
        for(int j=0;j<i;j++)
        {
        if(iscorrect(words[i],words[j]) && dp[i]<dp[j]+1)
        {
            dp[i]=dp[j]+1;
        }
        }
        max=Math.max(dp[i],max);
     }
     return max;
    }
    public static boolean iscorrect(String s1,String s2)
    {
        if(s1.length()!=s2.length()+1)
        {
            return false;
        }
        int first=0;
        int second=0;
        while(first<s1.length())
        {
            if(second<s2.length() && s1.charAt(first)==s2.charAt(second))
            {
                first++;
                second++;
            }
            else
            {
                first++;
            }
        }
        if(second==s2.length())
        {
            return true;
        }
        return false;
    }
}