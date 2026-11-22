class Solution {
    public boolean checkString(String s) {
        boolean b_occur=true;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='b' && b_occur==true)
            {
                b_occur=false;
            }
            else if(x=='a' && b_occur==false)
            {
                return false;
            }
        }
        return true;
    }
}