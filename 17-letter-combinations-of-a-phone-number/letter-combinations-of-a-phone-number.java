class Solution {
    String keypad[]={"#","@","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            return new ArrayList<>();
        }
        return helper(digits,0,digits.length());
    }
    public List<String> helper(String s,int idx,int d)
    {
        if(idx==d)
        {
            List li=new ArrayList<>();
            li.add("");
            return li;
        }
        char x=s.charAt(0);
        String roq=s.substring(1);
        List<String> ans=helper(roq,idx+1,d);
        List<String> res=new ArrayList<>();
        String str=keypad[Integer.parseInt(x+"")];
        for(int i=0;i<str.length();i++)
        {
            char f=str.charAt(i);
            for(int j=0;j<ans.size();j++)
            {
                res.add(f+ans.get(j));
            }
        }
        return new ArrayList<>(res);
    }
}