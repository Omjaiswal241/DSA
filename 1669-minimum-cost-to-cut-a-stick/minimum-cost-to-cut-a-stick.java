class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        ArrayList<Integer> li=new ArrayList<>();
        li.add(0);
        for(int i=0;i<cuts.length;i++)
        {
            li.add(cuts[i]);
        }
        li.add(n);
        int m=li.size();
        int dp[][]=new int[m][m];
        for(int i[]:dp)
        {
            Arrays.fill(i,-1);
        }
        return helper(li,dp,0,li.size()-1);
    }
    public int helper(ArrayList<Integer> li,int dp[][],int l,int h)
    {
        if(h-l<=1)
        {
            return 0;
        }
        if(dp[l][h]!=-1)
        {
            return dp[l][h];
        }
        int cost=Integer.MAX_VALUE;
        for(int i=l+1;i<h;i++)
        {
            int x=li.get(i);
            int curr=(li.get(h)-li.get(l))+helper(li,dp,l,i)+helper(li,dp,i,h);
            cost=Math.min(cost,curr);
        }
        return dp[l][h]=cost;
    }
}