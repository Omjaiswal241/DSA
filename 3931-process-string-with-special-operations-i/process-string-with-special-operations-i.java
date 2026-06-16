class Solution {
    public String processStr(String s) {
        String res="";
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(Character.isLetter(x))
            {
                res+=x;
            }
            else if(x=='*')
            {
                if(res.length()>0)
                {
                    res=res.substring(0,res.length()-1);
                }
            }
            else if(x=='#')
            {
                res=(res+res);
            }
            else
            {
                StringBuilder sb=new StringBuilder();
                for(int j=res.length()-1;j>=0;j--)
                {
                    sb.append(res.charAt(j));
                }
                res=sb.toString();
            }
        }
        return res;
    }
}