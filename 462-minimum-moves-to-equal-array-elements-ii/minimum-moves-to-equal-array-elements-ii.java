class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int tar=nums[n/2];
        int cnt=0;
        for(int i:nums)
        {
            cnt+=Math.abs(tar-i);
        }
        return cnt;
    }
}