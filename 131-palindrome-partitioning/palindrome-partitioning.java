class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        helper(0,s,new ArrayList<String>(),res);
        return res;
    }
    public void helper(int idx,String s,List<String> curr,List<List<String>> res)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(ispalin(s.substring(idx,i+1)))
            {
                curr.add(s.substring(idx,i+1));
                helper(i+1,s,curr,res);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean ispalin(String s)
    {
        int left=0,right=s.length()-1;
        while(left<right)
        {
            if(s.charAt(left)!=s.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}