class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum=0;
        for(int i:arr)
        {
            sum+=i;
        }
        if(sum%3!=0)
        {
            return false;
        }
        int target=sum/3;
        int f=0,cnt=0;
        for(int i:arr)
        {
            f+=i;
            if(f==target)
            {
                f=0;
                cnt++;
            }
        }
        return cnt>=3;
    }
}