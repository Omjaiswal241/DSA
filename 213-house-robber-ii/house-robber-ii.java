class Solution {
    public int rob(int[] nums) {
        if(nums.length==1)
        {
            return nums[0];
        }
        int max1=maxlinear(nums,0,nums.length-1);
        int max2=maxlinear(nums,1,nums.length);
        return Math.max(max1,max2);
    }
    public static int maxlinear(int ar[],int start,int end)
    {
        int oexc=0,oinc=ar[start];
        for(int i=start+1;i<end;i++)
        {
            int nexc=Math.max(oexc,oinc);
            int ninc=ar[i]+oexc;
            oexc=nexc;
            oinc=ninc;
        }
        return Math.max(oexc,oinc);
    }
}