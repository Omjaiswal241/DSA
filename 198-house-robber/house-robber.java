class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int oexc=0;
        int oinc=nums[0];
        for(int i=1;i<n;i++)
        {
            int ninc=nums[i]+oexc;
            int nexc=Math.max(oexc,oinc);
            oexc=nexc;
            oinc=ninc;
        }
        return Math.max(oexc,oinc);
    }
}