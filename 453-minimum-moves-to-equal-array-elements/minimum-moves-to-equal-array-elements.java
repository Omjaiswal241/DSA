class Solution {
    public int minMoves(int[] nums) {
        int n=nums.length;
        int cnt=0;
        int min=Integer.MAX_VALUE;
        for(int i:nums)
        {
            if(min>i)
            {
                min=i;
            }
        }
        for(int i:nums)
        {
            cnt+=(i-min);
        }
        return cnt;
    }
}