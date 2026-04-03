class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu=new PriorityQueue<>(Comparator.reverseOrder());
        for(int i:nums)
        {
            qu.add(i);
        }
        while(k>1)
        {
            qu.remove();
            k--;
        }
        return qu.remove();
    }
}