class Solution {
    public String longestPalindrome(String s) {
        String longest_str="";
        int maxlen=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
                String str=s.substring(i,j);
                if(isvalid(str) && str.length()>maxlen)
                {
                    maxlen=str.length();
                    longest_str=str;
                }
            }
        }
        return longest_str;
    }
    public static boolean isvalid(String str)
    {
        int i=0,j=str.length()-1;
        while(i<=j)
        {
            if(str.charAt(i)!=str.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}