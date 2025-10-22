class Solution {
    public int maximumSwap(int num) {
        String res=kswap(num+"",1);
        return Integer.parseInt(res);
    }
    public static String kswap(String str,int k)
    {
        if(k==0)
        {
            return str;
        }
        String max=str;
        for(int i=0;i<str.length()-1;i++)
        {
            for(int j=i+1;j<str.length();j++)
            {
                String newstr=swap(str,i,j);
                if(Integer.parseInt(newstr)>Integer.parseInt(max))
                {
                    max=newstr;
                }
                kswap(newstr,k-1);
            }
        }
        return max;
    }
    public static String swap(String str,int i,int j)
    {
        StringBuilder sb=new StringBuilder(str);
        char ich=sb.charAt(i);
        char jch=sb.charAt(j);
        sb.setCharAt(i,jch);
        sb.setCharAt(j,ich);
        return sb.toString();
    }
}