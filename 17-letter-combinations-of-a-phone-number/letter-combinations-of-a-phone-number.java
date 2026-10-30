class Solution {
    String str[]={"@","%","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0)
        {
            List<String> base=new ArrayList<>();
            base.add("");
            return base;
        }   
        char x=digits.charAt(0);
        List<String> roq=letterCombinations(digits.substring(1));
        List<String> res=new ArrayList<>();
        String ts=str[Integer.parseInt(x+"")];
        for(int f=0;f<ts.length();f++)
        {
            char v=ts.charAt(f);
            for(int j=0;j<roq.size();j++)
            {
                res.add(""+v+roq.get(j));
            }
        }
        return res;
    }
}