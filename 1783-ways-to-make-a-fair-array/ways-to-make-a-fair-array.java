class Solution {
    public int waysToMakeFair(int[] nums) {
        int n=nums.length;
        int even[]=new int[n];
        int odd[]=new int[n];
        int evensum=0;
        int oddsum=0;
        for(int i=0;i<n;i++)
        {
            if(i%2==0)
            {
                evensum+=nums[i];
            }
            else
            {
                oddsum+=nums[i];
            }
            even[i]=evensum;
            odd[i]=oddsum;
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            if(i==0)
            {
                int evens=odd[n-1]-odd[i];
                int odds=even[n-1]-even[i];
                if(evens==odds)
                {
                    cnt++;
                }
                continue;
            }
            else
            {
                int evens=even[i-1]+odd[n-1]-odd[i];
                int odds=odd[i-1]+even[n-1]-even[i];
                if(evens==odds)
                {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}