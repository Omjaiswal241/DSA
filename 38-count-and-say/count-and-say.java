class Solution {
    public String countAndSay(int n) {
        if(n==1)
        {
            return "1";
        }
        String say=countAndSay(n-1);
        int i=0,j=0;
        StringBuilder sb=new StringBuilder();
        while(j<say.length())
        {
            while(j<say.length() && say.charAt(i)==say.charAt(j))
            {
                j++;
            }
            int len=j-i;
            sb.append(""+len+say.charAt(i));
            i=j;
        }
        return sb.toString();
    }
}