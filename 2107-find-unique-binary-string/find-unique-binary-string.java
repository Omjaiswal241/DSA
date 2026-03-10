class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int f=nums[0].length();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            int n=Integer.parseInt(nums[i],2);
            hs.add(n);
        }
        for(int i=0;i<Math.pow(2,f);i++)
        {
            if(!hs.contains(i))
            {
                String b=Integer.toBinaryString(i);
                while(b.length()<f)
                {
                    b="0"+b;
                }
                return b;   
            }
        } 
        return "";
    }
}