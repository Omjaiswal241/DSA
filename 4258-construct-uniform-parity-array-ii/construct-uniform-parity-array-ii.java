class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean odd=false;
        int evenmin=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i:nums1)
        {
            if(i%2==1)
            {
                odd=true;
            }
            if(i%2==0 && i<evenmin)
            {
                evenmin=i;
            }
            if(i<min)
            {
                min=i;
            }
        }
        return odd?evenmin!=min:true;
    }
}