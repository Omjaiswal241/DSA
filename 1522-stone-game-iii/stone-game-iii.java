class Solution {
    int n;
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        int dp[][]=new int[2][n+1];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        int sum=0;
        for(int i:stoneValue)
        {
            sum+=i;
        }
        int alice=solve(stoneValue,1,0,dp);
        int bob=sum-alice;
        if(alice==bob)
        {
            return "Tie";
        }
        return alice>bob?"Alice":"Bob";
    }
    public int solve(int stone[],int person,int idx,int dp[][])
    {
        if(idx>=n)
        {
            return 0;
        }
        if(dp[person][idx]!=-1)
        {
            return dp[person][idx];
        }
        int stones=0;
        int res=(person==1)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(3,n-idx);x++)
        {
            stones+=stone[idx+x-1];
            if(person==1)
            {
                res=Math.max(res,stones+solve(stone,0,idx+x,dp));
            }
            else
            {
                res=Math.min(res,solve(stone,1,idx+x,dp));
            }
        }
        return dp[person][idx]=res;
    }
}