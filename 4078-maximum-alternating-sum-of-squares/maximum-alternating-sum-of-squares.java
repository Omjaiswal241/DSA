class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int []ar=new int[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=Math.abs(nums[i]);
        }
        Arrays.sort(ar);
        int m=(n+1)/2;
        int odd[]=new int[m];
        int even[]=new int[n/2];
        for(int i=0;i<n/2;i++)
        {
            even[i]=ar[i];
        }
        int k=0;
        for(int i=n/2;i<n;i++)
        {
            odd[k++]=ar[i];
        }
        long sum=0;
        for(int i=0;i<even.length;i++)
        {
            sum-=(int)Math.pow(even[i],2);
        }
        for(int i=0;i<odd.length;i++)
        {
            sum+=(int)Math.pow(odd[i],2);
        }
        return sum;
    }
}