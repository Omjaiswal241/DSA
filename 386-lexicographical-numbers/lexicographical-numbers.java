class Solution {
    List<Integer> res=new ArrayList<>();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<=9;i++)
        {
            if(i<=n)
            {
                helper(i,n);
            }
        }
        return res;
    }
    public void helper(int i,int n)
    {
        res.add(i);
        for(int j=0;j<=9;j++)
        {
            int d=i*10+j;
            if(d<=n)
            {
                helper(d,n);
            }
            else
            {
                break;
            }
        }
    }
}