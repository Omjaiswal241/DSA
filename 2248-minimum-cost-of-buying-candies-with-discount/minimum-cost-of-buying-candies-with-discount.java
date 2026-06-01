class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int res=0;
        int i=cost.length-1;
        while(i-2>=0)
        {
            res+=cost[i]+cost[i-1];
            i=i-3;
        }
        while(i>=0)
        {
            res+=cost[i];
            i--;
        }
        return res;
    }
}