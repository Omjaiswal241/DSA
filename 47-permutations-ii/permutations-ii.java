class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
       HashMap<Integer,Integer> hm=new HashMap<>();
       for(int i=0;i<nums.length;i++)
       {
        hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
       }
       List<Integer> li=new ArrayList<>();
       helper(nums,0,nums.length,li,hm); 
       return res;
    }
    public void helper(int nums[],int cs,int ts,List<Integer> li,HashMap<Integer,Integer> hm)
    {
        if(cs==ts)
        {
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i:hm.keySet())
        {
            int freq=hm.get(i);
            if(freq>0)
            {
                li.add(i);
                hm.put(i,hm.get(i)-1);
                helper(nums,cs+1,ts,li,hm);
                int  el=li.get(li.size()-1);
                hm.put(el,hm.get(el)+1);
                li.remove(li.size()-1);
            }
        }

    }
}