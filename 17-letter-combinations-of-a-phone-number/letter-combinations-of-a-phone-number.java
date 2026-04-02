class Solution {
    String keypad[]={"@","#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
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
            List<String> li=new ArrayList<>();
            li.add("");
            return li;
        }
        char a=s.charAt(0);
        String roq=s.substring(1);
        List<String> temp=helper(roq,idx+1,d);
        List<String> res=new ArrayList<>();
        String f=keypad[Integer.parseInt(a+"")];
        for(int i=0;i<f.length();i++)
        {
            for(int j=0;j<temp.size();j++)
            {
                res.add(f.charAt(i)+temp.get(j));
            }
        }
        return res;
    }
}