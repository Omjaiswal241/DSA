class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int pre[]=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,nums[i]);
            int a=gcd(nums[i],max);
            pre[i]=a;
        }
        Arrays.sort(pre);
        int low=0,high=n-1;
        long res=0;
        while(low<high)
        {
            int a=gcd(pre[low],pre[high]);
            res+=a;
            low++;
            high--;
        }
        return res;
    }
    public int gcd(int a,int b)
    {
        while(b!=0)
        {
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}