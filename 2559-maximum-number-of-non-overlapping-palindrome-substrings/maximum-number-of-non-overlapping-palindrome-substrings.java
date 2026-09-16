class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1)
        {
            return n;
        }
        boolean ispalin[][]=new boolean[n+1][n+1];
        for(int L=1;L<=n;L++)
        {
            for(int i=0;i+L<=n;i++)
            {
                int j=i+L-1;
                if(i==j)
                {
                    ispalin[i][j]=true;
                }
                else if(i+1==j)
                {
                    ispalin[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    ispalin[i][j]=(s.charAt(i)==s.charAt(j)) && ispalin[i+1][j-1];
                }
            }
        }
        int dp[][]=new int[n+1][n+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(ispalin[i][j])
                {
                    int take=1+(j+k<=n?dp[j+1][j+k]:0);
                    int grow=dp[i][j+1];
                    int slide=dp[i+1][j+1];
                    dp[i][j]=Math.max(take,Math.max(grow,slide));
                }
                int grow=dp[i][j+1];
                int slide=dp[i+1][j+1];
                dp[i][j]=Math.max(dp[i][j],Math.max(grow,slide));
            }
        }
        return dp[0][k-1];
    }
}