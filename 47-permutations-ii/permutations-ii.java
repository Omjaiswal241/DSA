class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        perm(new ArrayList<>(),hm,nums.length,li);
        return li;
    }
    public static void perm(List<Integer> temp,HashMap<Integer,Integer> hm,int ts,List<List<Integer>> li)
    {
        if(temp.size()==ts)
        {
            li.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int i:hm.keySet())
        {
            int freq=hm.get(i);
            if(freq>0)
            {
                temp.add(i);
                hm.put(i,freq-1);

                perm(temp,hm,ts,li);

                temp.remove(temp.size()-1);
                hm.put(i,freq);
            }
        }
    }
}