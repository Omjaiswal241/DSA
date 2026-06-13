class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tot_gas=0;
        int tot_cost=0;
        int n=gas.length;
        for(int i=0;i<n;i++)
        {
            tot_gas+=gas[i];
            tot_cost+=cost[i];
        }
        if(tot_gas<tot_cost)
        {
            return -1;
        }
        int total=0;
        int res=0;
        for(int i=0;i<n;i++)
        {
            total+=gas[i]-cost[i];
            if(total<0)
            {
                total=0;
                res=i+1;
            }
        }
        return res;
    }
}