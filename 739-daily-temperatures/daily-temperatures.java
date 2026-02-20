class Solution {
    class Pair
    {
        int val,idx;
        Pair(int val,int idx)
        {
            this.val=val;
            this.idx=idx;
        }
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int ans[]=new int[n];
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(temperatures[n-1],n-1));
        for(int i=n-2;i>=0;i--)
        {
            Pair top=new Pair(temperatures[i],i);
            if(st.peek().val>top.val)
            {
                ans[i]=st.peek().idx-i;
                st.push(top);
            }
            else
            {
                while(st.size()!=0 && st.peek().val<=top.val)
                {
                    st.pop();
                }
                if(st.size()==0)
                {
                    ans[i]=0;
                }
                else
                {
                ans[i]=st.peek().idx-i;
                }
                st.push(top);
            }
        }
        return ans;
    }
}