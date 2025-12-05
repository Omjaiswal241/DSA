class Solution {
    public int sumSubarrayMins(int[] arr) {
        int  mod=1000000007;
        int n=arr.length;
        int nse[]=new int[n];
        int prev[]=new int[n];
        Stack<Integer> st1=new Stack<Integer>();
        st1.push(0);
        prev[0]=-1;
        for(int i=1;i<n;i++)
        {
            while(st1.size()>0 && arr[st1.peek()]>=arr[i])
            {
                st1.pop();
            }
            if(st1.size()==0)
            {
                prev[i]=-1;
            }
            else
            {
                prev[i]=st1.peek();
            }
            st1.push(i);
        }
        Stack<Integer> st2=new Stack<Integer>();
        st2.push(n-1);
        nse[n-1]=n;
        for(int i=n-2;i>=0;i--)
        {
            while(st2.size()>0 && arr[st2.peek()]>arr[i])
            {
                st2.pop();
            }
            if(st2.size()==0)
            {
                nse[i]=n;
            }
            else
            {
                nse[i]=st2.peek();
            }
            st2.push(i);
        } 
        long sum=0;
        for(int i=0;i<n;i++)
        {
            int left=i-prev[i];
            int right=nse[i]-i;
            long freq=left*right%mod;
            int val=(int)((freq*arr[i])%mod);
            sum=(sum+val)%mod;
        }
        return (int)sum;
    }
}