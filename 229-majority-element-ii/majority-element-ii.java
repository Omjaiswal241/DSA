class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int n=nums.length;
        int f=n/3;
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        for(int i:nums)
        {
            int a=hm.get(i);
            if(a>f)
            {
                hs.add(i);
            }
        }
        List<Integer> li=new ArrayList<>(hs);
        return li;
    }
}