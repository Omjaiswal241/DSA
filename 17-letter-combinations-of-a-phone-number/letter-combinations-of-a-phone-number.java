class Solution {
    static String keypad[]={"","@","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) 
    {
        if(digits.length()==0)
        {
            List<String> res=new ArrayList<>();
            return res;
        }
        List<String> ans=new ArrayList<>();
        char x=digits.charAt(0);
        String roq=digits.substring(1);
        List<String> key=letterCombinations(roq);
        if(key.size()==0)
        {
            key.add("");
        }
        String f=keypad[Character.getNumericValue(x)];
        for(int i=0;i<f.length();i++)
        {
            for(int j=0;j<key.size();j++)
            {
                ans.add(f.charAt(i)+key.get(j));
            }
        }
        return ans;
    }
}