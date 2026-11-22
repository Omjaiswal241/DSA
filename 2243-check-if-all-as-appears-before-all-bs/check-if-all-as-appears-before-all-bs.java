class Solution {
    public boolean checkString(String s) {
        boolean b_occur=false;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            if(x=='b' && b_occur==false)
            {
                b_occur=true;
            }
            else if(x=='a' && b_occur==true)
            {
                return false;
            }
        }
        return true;
    }
}