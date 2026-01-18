class Solution {
    public int rob(int[] nums) {
        int oinc=nums[0];
        int oexc=0;
        for(int i=1;i<nums.length;i++)
        {
            int ninc=Math.max(oexc+nums[i],oinc);
            int nexc=oinc;
            oinc=ninc;
            oexc=nexc;
        }
        return Math.max(oinc,oexc);
    }
}