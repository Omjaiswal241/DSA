class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                matrix[i][j]=(j>0)?matrix[i][j-1]+matrix[i][j]:matrix[i][j];
            }
        }
        int cnt=0;
        for(int sc=0;sc<m;sc++)
        {
            for(int ec=sc;ec<m;ec++)
            {
                HashMap<Integer,Integer> hm=new HashMap<>();
                hm.put(0,1);
                int csum=0;
                for(int r=0;r<n;r++)
                {
                    csum+=(sc>0)?matrix[r][ec]-matrix[r][sc-1]:matrix[r][ec];
                    int rem=csum-target;
                    if(hm.containsKey(rem))
                    {
                        cnt+=hm.get(rem);
                    }
                    hm.put(csum,hm.getOrDefault(csum,0)+1);
                }
            }
        }
        return cnt;
    }
}