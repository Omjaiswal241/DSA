class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu=new PriorityQueue<>();
        int i=0;
        while(i<nums.length)
        {
        if(qu.size()<k)
        {
            qu.add(nums[i]);
        }
        else if(qu.size()==k)
        {
            if(qu.peek()<nums[i])
            {
                qu.remove();
                qu.add(nums[i]);
            }
        }
        i++;
        }
        return qu.peek();
    }
}