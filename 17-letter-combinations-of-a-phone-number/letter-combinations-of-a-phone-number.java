class Solution {
    String ar[]={"@","#","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            List<String> base=new ArrayList<>();
            base.add("");
            return base;
        }   
        char ch=digits.charAt(0);
        String roq=digits.substring(1);
        List<String> temp=letterCombinations(roq);
        String f=ar[Integer.parseInt(ch+"")];
        List<String> res=new ArrayList<>();
        for(int i=0;i<f.length();i++)
        {
            char x=f.charAt(i);
            for(int j=0;j<temp.size();j++)
            {
                res.add(x+temp.get(j)+"");
            }
        }
        return res;
    }
}