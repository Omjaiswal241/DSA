class Solution {
    String temp[]={"#","@","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {   
        if(digits.length()==0)
        {
            List<String> base=new ArrayList<>();
            base.add("");
            return base; 
        }
        char x=digits.charAt(0);
        String roq=digits.substring(1);
        List<String> f=letterCombinations(roq);
        String y=temp[Integer.parseInt(x+"")];
        List<String> res=new ArrayList<>();
        for(int i=0;i<y.length();i++)
        {
            char g=y.charAt(i);
            for(int j=0;j<f.size();j++)
            {
                res.add(g+f.get(j));
            }
        }
        return res;
    }
}