class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        ArrayList<Integer> li=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(asteroids[i]>0)
            {
                st.push(asteroids[i]);
            }
            else
            {
                while(st.size()>0 && st.peek()>0 && st.peek()<Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                if(st.size()>0 && st.peek()==Math.abs(asteroids[i]))
                {
                    st.pop();
                }
                else if(st.size()==0 || st.peek()<0)
                {
                    st.push(asteroids[i]);
                }
            }
        }
        int res[]=new int[st.size()];
        for(int i=0;i<res.length;i++)
        {
            res[i]=st.get(i);
        }
        return res;
    }
}