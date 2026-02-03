class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                if(ispalin(s.substring(i,j)))
                {
                    count++;
                }
            }
        }
        return count;
    }
    // public static boolean ispalin(String s)
    // {
    //     String str=reverse(s);
    //     int n=s.length();
    //     int dp[][]=new int[n][n];
    //     for(int i[]:dp)
    //     {
    //         Arrays.fill(i,-1);
    //     }
    //     int c=check(s,n-1,str,n-1,dp);
    //     return (c==n);
    // }
    // public static int check(String s,int idx1,String t,int idx2,int [][]dp)
    // {
    //     if(idx1<0 || idx2<0)
    //     {
    //         return 0;
    //     }
    //     if(dp[idx1][idx2]!=-1)
    //     {
    //         return dp[idx1][idx2];
    //     }
    //     if(s.charAt(idx1)==t.charAt(idx2))
    //     {
    //         return dp[idx1][idx2]=1+check(s,idx1-1,t,idx2-1,dp);
    //     }
    //     return dp[idx1][idx2]=Math.max(check(s,idx1-1,t,idx2,dp),check(s,idx1,t,idx2-1,dp));
    // }
    // public static String reverse(String str)
    // {
    //     StringBuilder sb=new StringBuilder();
    //     for(int i=str.length()-1;i>=0;i--)
    //     {
    //         sb.append(str.charAt(i));
    //     }
    //     return sb.toString();
    // }
    public static boolean ispalin(String s)
    {
        int start=0,end=s.length()-1;
        while(start<end)
        {
            if(s.charAt(start)!=s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}