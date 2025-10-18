class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> li=new ArrayList<List<Integer>>();
        helper(new int[n],1,k,-1,li);
        return li;
    }
    public static void helper(int ar[],int ci,int ti,int lb,List<List<Integer>> li)
    {
        if(ci>ti)
        {
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<ar.length;i++)
            {
                if(ar[i]!=0)
                {
                    temp.add(i+1);
                }
            }
            li.add(temp);
            return;
        }
        for(int i=lb+1;i<ar.length;i++)
        {
            ar[i]=1;
            helper(ar,ci+1,ti,i,li);
            ar[i]=0;
        }
    }
}