class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int height[]=new int[m];
        int max_area=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                height[j]=(matrix[i][j]=='0')?0:height[j]+1;
            }
            int ans=histogram(height);
            max_area=Math.max(max_area,ans);
        }
        return max_area;
    }
    public int histogram(int height[])
    {
        int n=height.length;
        int pse[]=new int[n];
        int nse[]=new int[n];
        pse[0]=-1;
        nse[n-1]=n;
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();
        st1.push(0);
        st2.push(n-1);
        int i=1;
        while(i<n)
        {
            while(st1.size()>0 && height[st1.peek()]>=height[i])
            {
                st1.pop();
            }
            if(st1.size()==0)
            {
                st1.push(i);
                pse[i]=-1;
            }
            else
            {
                pse[i]=st1.peek();
                st1.push(i);
            }
            i++;
        }
        int j=n-2;
        while(j>=0)
        {
            while(st2.size()>0 && height[st2.peek()]>=height[j])
            {
                st2.pop();
            }
            if(st2.size()==0)
            {
                st2.push(j);
                nse[j]=n;
            }
            else
            {
                nse[j]=st2.peek();
                st2.push(j);
            }
            j--;
        }
        int res=0;
        for(int f=0;f<n;f++)
        {
            res=Math.max(res,(nse[f]-pse[f]-1)*height[f]);
        }
        return res;
    }
}