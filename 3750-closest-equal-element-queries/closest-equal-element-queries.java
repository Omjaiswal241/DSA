class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        List<Integer> ans=new ArrayList<Integer>();
        HashMap<Integer,List<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            List<Integer> list=hm.getOrDefault(nums[i],new ArrayList<>());
            list.add(i);
            hm.put(nums[i],list);
        }
        for(int i:queries)
        {
            List<Integer> temp=hm.get(nums[i]);
            if(temp.size()==1)
            {
                ans.add(-1);
                continue;
            }
            int p=lowerbound(temp,i);
            int size=temp.size();
            int right=(p+1)%size;
            int d=Math.abs(temp.get(right)-temp.get(p));
            int circular=n-d;
            int res=Math.min(d,circular);
            int left=(p-1+size)%size;
            d=Math.abs(temp.get(left)-temp.get(p));
            circular=n-d;
            res=Math.min(res,Math.min(d,circular));
            ans.add(res);
        }
        return ans;
    }
    public int lowerbound(List<Integer> li,int n)
    {
        int low=0;
        int high=li.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(li.get(mid)==n)
            {
                return mid;
            }
            else if(li.get(mid)<n)
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return 0;
    }
}