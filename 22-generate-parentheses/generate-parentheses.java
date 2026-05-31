class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();
        helper(n,"",res);
        return res;
    }
    public void helper(int n,String s,List<String> res)
    {
        if(s.length()==2*n)
        {
            if(isvalid(s))
            {
                res.add(s);
            }
            return;
        }
        helper(n,s+"(",res);
        helper(n,s+")",res);
    }
    public boolean isvalid(String s)
    {
        if(s.charAt(0)==')')
        {
            return false;
        }
        int i=0;
        for(int j=0;j<s.length();j++)
        {
            if(s.charAt(j)==')')
            {
                i--;
            }
            else
            {
                i++;
            }
            if(i<0)
            {
                return false;
            }
        }
        if(i==0)
        {
            return true;
        }
        return false;
    }
}