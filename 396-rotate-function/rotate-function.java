class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum=0;
        int n=nums.length;
        int f=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            f+=i*nums[i];
        }
        int res=f;
        for(int i=0;i<n;i++)
        {
            int newF=sum+f-n*nums[n-i-1];
            res=Math.max(newF,res);
            f=newF;
        }
        return res;
    }
}