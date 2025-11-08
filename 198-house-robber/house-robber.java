class Solution {
    public int rob(int[] nums) {
       int oinc=nums[0],oexc=0;
       for(int i=1;i<nums.length;i++)
       {
        int nexc=Math.max(oinc,oexc);
        int ninc=nums[i]+oexc;
        oexc=nexc;
        oinc=ninc;
       }
       return Math.max(oexc,oinc); 
    }
}