class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int dp[][]=new int[cuts.length+2][cuts.length+2];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        ArrayList<Integer> li=new ArrayList<>();
        li.add(0);
        for(int i=0;i<cuts.length;i++)
        {
            li.add(cuts[i]);
        }
        li.add(n);
        return helper(li,0,li.size()-1,dp);
    }
    public static int helper(ArrayList<Integer> li,int l,int h,int dp[][])
    {
        if(h-l==1)
        {
            return 0;
        }
        if(dp[l][h]!=-1)
        {
            return dp[l][h];
        }
        int minsteps=Integer.MAX_VALUE;
        for(int i=l+1;i<=h-1;i++)
        {
            int steps=(li.get(h)-li.get(l))+helper(li,l,i,dp)+helper(li,i,h,dp);
            minsteps=Math.min(steps,minsteps);
        }
        return dp[l][h]=minsteps;
    }
}