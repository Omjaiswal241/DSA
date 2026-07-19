class Solution {
    public String smallestSubsequence(String s) {
        int n=s.length();
        int last[]=new int[26];
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            int idx=x-'a';
            last[idx]=i;
        }
        boolean temp[]=new boolean[26];
        StringBuilder sb=new StringBuilder(); 
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            int idx=x-'a';
            if(sb.length()==0)
            {
                sb.append(x);
                temp[idx]=true;
                continue;
            }
            if(temp[idx]==false)
            {
                int diff=x-sb.charAt(sb.length()-1);
                if(diff>0)
                {
                    sb.append(x);
                    temp[idx]=true;
                }
                else if(diff<0)
                {
                    while(sb.length()>0 && diff<0 && last[sb.charAt(sb.length()-1)-'a']>i)
                    {
                        temp[sb.charAt(sb.length()-1)-'a']=false;
                        sb.deleteCharAt(sb.length()-1);
                        diff=sb.length()==0?1:x-sb.charAt(sb.length()-1);
                    }
                    sb.append(x);
                    temp[idx]=true;
                }
            }
        }
        return sb.toString();
    }
}