class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();
        int start[]=new int[26];
        Arrays.fill(start,-1);
        int end[]=new int[26];
        for(int i=0;i<n;i++)
        {
            int idx=s.charAt(i)-'a';
            if(start[idx]==-1)
            {
                start[idx]=i;
            }
            end[idx]=i;
        }
        boolean isvalid[]=new boolean[26];
        Arrays.fill(isvalid,true);
        for(int c=0;c<26;c++)
        {
            if(start[c]==-1)
            {
                continue;
            }
            for(int i=start[c];i<=end[c];i++)
            {
                int idx=s.charAt(i)-'a';
                if(start[idx]<start[c])
                {
                    isvalid[c]=false;
                    break;
                }
                end[c]=Math.max(end[c],end[idx]);
            }
        }
        int lasttakenidx=Integer.MAX_VALUE;
        List<String> res=new ArrayList<>();
        for(int i=n-1;i>=0;i--)
        {
            int idx=s.charAt(i)-'a';
            if(isvalid[idx])
            {
                if(i==start[idx] && end[idx]<lasttakenidx)
                {
                    res.add(s.substring(start[idx],end[idx]+1));
                    lasttakenidx=start[idx];
                }
            }
        }
        return res;
    }
}