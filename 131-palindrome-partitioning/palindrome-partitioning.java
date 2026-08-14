class Solution {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s,0,new ArrayList<>());
        return res;
    }
    public void helper(String s,int idx,List<String> li)
    {
        if(idx==s.length())
        {
            res.add(new ArrayList<>(li));
            return;
        }
        for(int i=idx;i<s.length();i++)
        {
            if(ispalin(s.substring(idx,i+1)))
            {
                li.add(s.substring(idx,i+1));
                helper(s,i+1,li);
                li.remove(li.size()-1);
            }
        }
    }
    public boolean ispalin(String s)
    {
        int low=0,high=s.length()-1;
        while(low<high)
        {
            if(s.charAt(low)!=s.charAt(high))
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}