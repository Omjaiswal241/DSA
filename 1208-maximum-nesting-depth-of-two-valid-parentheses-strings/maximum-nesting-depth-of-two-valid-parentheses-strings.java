class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int res[]=new int[n];
        int depth=0;
        for(int i=0;i<n;i++)
        {
            char x=seq.charAt(i);
            if(x=='(')
            {
                depth++;
                res[i]=depth%2==0?0:1;
            }
            else
            {
                res[i]=depth%2==0?0:1;
                depth--;
            }
        }
        return res;
    }
}