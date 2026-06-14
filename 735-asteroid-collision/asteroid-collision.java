class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        Stack<Integer> st=new Stack<>();
        int i=0;
        while(i<asteroids.length)
        {
            if(asteroids[i]<0)
            {
                while(st.size()!=0 && st.peek()>=0 && Math.abs(asteroids[i])>st.peek())
                {
                    st.pop();
                }
                if(st.size()!=0 && st.peek()<0)
                {
                    st.push(asteroids[i]);
                }
                if(st.size()==0)
                {
                    st.push(asteroids[i]);
                }
                if(Math.abs(asteroids[i])==st.peek())
                {
                    st.pop();
                }
                i++;
            }
            else
            {
                st.push(asteroids[i]);
                i++;
            }
    }
    int x=st.size();
    int res[]=new int[x];
    for(int j=x-1;j>=0;j--)
    {
        res[j]=st.pop();
    }
    return res;
}
}