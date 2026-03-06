class Solution {
    public boolean checkOnesSegment(String s) {
       boolean zerofound=false;
       for(int i=0;i<s.length();i++)
       {
        char x=s.charAt(i);
        if(x=='0')
        {
            zerofound=true;
        }
        else if(zerofound)
        {
            return false;
        }
       } 
       return true;
    }
}