class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(new int[n],0,k,-1);
        return res;
    }
    public void helper(int box[],int ci,int ti,int lb)
    {
        if(ci==ti)
        {
            List<Integer> li=new ArrayList<>();
            for(int i:box)
            {
                if(i!=0)
                {
                    li.add(i);
                }
            }
            res.add(li);
            return;
        }
        for(int i=lb+1;i<box.length;i++)
        {
            box[i]=i+1;
            helper(box,ci+1,ti,i);
            box[i]=0;
        }
    }
}