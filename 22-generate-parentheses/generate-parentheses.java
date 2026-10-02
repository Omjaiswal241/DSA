class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        solve(n,0,"",0,0,res);
        return res;
    }
    public void solve(int n,int i,String str,int open,int close,List<String> res)
    {
        if(i==2*n)
        {
            res.add(str);
            return;
        }
        if(open<n)
        {
            solve(n,i+1,str+"(",open+1,close,res);
        }
        if(open>close)
        {
        solve(n,i+1,str+")",open,close+1,res);
        }
    }
}