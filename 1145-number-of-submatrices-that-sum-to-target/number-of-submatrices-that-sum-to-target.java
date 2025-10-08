class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans=0,m=matrix.length,n=matrix[0].length;
        for(int i=0;i<m;i++)
        {
            for(int c=1;c<n;c++)
            {
                matrix[i][c]+=matrix[i][c-1];
            }
        }
        for(int colstart=0;colstart<n;colstart++)
        {
            for(int colend=colstart;colend<n;colend++)
            {
                HashMap<Integer,Integer> hm=new HashMap<>();
                hm.put(0,1);
                int currsum=0;
                for(int row=0;row<m;row++)
                {
                    currsum+=matrix[row][colend]-(colstart>0?matrix[row][colstart-1]:0);
                    ans+=hm.getOrDefault(currsum-target,0);
                    hm.put(currsum,hm.getOrDefault(currsum,0)+1);
                }
            }
        }
        return ans;
    }
}