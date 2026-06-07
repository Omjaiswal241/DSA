class Solution {
    public int rob(int[] nums) {
        int oexc=0;
        int oinc=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int nexc=Math.max(oinc,oexc);
            int ninc=oexc+nums[i];
            oexc=nexc;
            oinc=ninc;
        }
        return Math.max(oexc,oinc);
    }
}