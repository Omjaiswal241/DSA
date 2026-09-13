class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int mat[][]=new int[n][m];
        for(int j=0;j<m;j++)
        {
            mat[0][j]=(matrix[0][j]=='1')?1:0;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                mat[j][i]=(matrix[j][i]=='0')?0:Integer.parseInt(matrix[j][i]+"")+mat[j-1][i];
            }
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            res=Math.max(res,solve(mat[i]));
        }
        return res;
    }
    public int solve(int ar[])
    {
        int n=ar.length;
        int pse[]=new int[n];
        Stack<Integer> st1=new Stack<>();
        pse[0]=-1;
        st1.push(0);
        int i=1;
        while(i<n)
        {
            if(ar[i]>ar[st1.peek()])
            {
                pse[i]=st1.peek();
                st1.push(i);
            }
            else
            {
                while(st1.size()!=0 && ar[i]<=ar[st1.peek()])
                {
                    st1.pop();
                }
                if(st1.size()==0)
                {
                    pse[i]=-1;
                }
                else
                {
                    pse[i]=st1.peek();
                }
                st1.push(i);
            }
            i++;
        }
        Stack<Integer> st2=new Stack<Integer>();
        int nse[]=new int[n];
        nse[n-1]=n;
        st2.push(n-1);
        int j=n-2;
        while(j>=0)
        {
            if(ar[st2.peek()]<ar[j])
            {
                nse[j]=st2.peek();
                st2.push(j);
            }
            else
            {
                while(st2.size()!=0 && ar[j]<=ar[st2.peek()])
                {
                    st2.pop();
                }
                if(st2.size()==0)
                {
                    nse[j]=n;
                }
                else
                {
                    nse[j]=st2.peek();
                }
                st2.push(j);
            }
            j--;
        }
        int ans=0;
        for(int k=0;k<n;k++)
        {
            ans=Math.max(ans,(nse[k]-pse[k]-1)*ar[k]);
        }
        return ans;
    }






























}