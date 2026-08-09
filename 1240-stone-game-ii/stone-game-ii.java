class Solution {
    int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        int dp[][][]=new int[2][n+1][n+1];
        for(int i[][]:dp)
        {
            for(int j[]:i)
            {
                Arrays.fill(j,-1);
            }
        }
        return solve(piles,1,0,1,dp);  // solve(piles,Alice,idx,M,dp)
    }
    public int solve(int []piles,int person,int idx,int M,int [][][]dp)
    {
        if(idx>=n)
        {
            return 0;
        }
        if(dp[person][idx][M]!=-1)
        {
            return dp[person][idx][M];
        }
        int stones=0;
        int res=(person==1)?Integer.MIN_VALUE:Integer.MAX_VALUE;  // person=1 -> Alice
        for(int x=1;x<=Math.min(2*M,n-idx);x++)
        {
            stones+=piles[idx+x-1];
            if(person==1)
            {
                res=Math.max(res,stones+solve(piles,0,idx+x,Math.max(x,M),dp));
            }
            else
            {
                res=Math.min(res,solve(piles,1,idx+x,Math.max(x,M),dp));
            }
        }
        return dp[person][idx][M]=res;
    }
}