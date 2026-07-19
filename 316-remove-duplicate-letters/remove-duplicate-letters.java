class Solution {
    public String removeDuplicateLetters(String s) {
        int n=s.length();
        int last_occur[]=new int[26];
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            int idx=x-'a';
            last_occur[idx]=i;
        }
        StringBuilder ans=new StringBuilder();
        boolean used[]=new boolean[26];
        for(int i=0;i<n;i++)
        {
            char x=s.charAt(i);
            int idx=x-'a';
            if(ans.length()==0)
            {
                used[idx]=true;
                ans.append(x);
                continue;
            }
            if(used[idx]==false)
            {
                char a=ans.charAt(ans.length()-1);
                int diff=x-a;
                if(diff>0)
                {
                    used[idx]=true;
                    ans.append(x);
                }
                else if(diff<0)
                {
                    while(ans.length()>0 && diff<0 && last_occur[ans.charAt(ans.length()-1)-'a']>i)
                    {
                        used[ans.charAt(ans.length()-1)-'a']=false;
                        ans.deleteCharAt(ans.length()-1);
                        diff=ans.length()==0?0:x-ans.charAt(ans.length()-1);
                    }
                    used[idx]=true;
                    ans.append(x);
                }
            }
        }
        return ans.toString();
    }
}