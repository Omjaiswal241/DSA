class Solution {
    public int[] findPeakGrid(int[][] mat) {
       int n=mat.length; 
       int m=mat[0].length;
       int low=0;
       int high=m-1;
       while(low<=high)
       {
        int mid=low+(high-low)/2;
        int row=max(mat,mid);  //maximum from a col
        int left=mid-1>=0?mat[row][mid-1]:-1;
        int right=mid+1<m?mat[row][mid+1]:-1;
        if(left<mat[row][mid] && right<mat[row][mid])
        {
            return new int[]{row,mid};
        }
        else if(left>mat[row][mid])
        {
            high=mid-1;
        }
        else
        {
            low=mid+1;
        }
       } 
       return new int[]{-1,-1};
    }
    public static int max(int ar[][],int col)
    {
        int idx=-1;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<ar.length;i++)
        {
            if(ar[i][col]>max)
            {
                max=ar[i][col];
                idx=i;
            }
        }
        return idx;
    }
}