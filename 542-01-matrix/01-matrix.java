class Solution {
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        boolean [][]visited=new boolean[m][n];
        int dist[][]=new int[m][n];
        Queue<int[]> qu=new ArrayDeque<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    qu.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int level=0;
        while(qu.size()!=0)
        {
            int size=qu.size();
            while(size-->0)
            {
                int curr[]=qu.remove();
                int row=curr[0];
                int col=curr[1];
                for(int dir[]:directions)
                {
                    int newrow=row+dir[0];
                    int newcol=col+dir[1];
                    if(newrow<0 || newcol<0 || newrow>=m || newcol>=n || visited[newrow][newcol])
                    {
                        continue;
                    }
                    qu.add(new int[]{newrow,newcol});
                    visited[newrow][newcol]=true;
                }
                dist[row][col]=level;
            }
            level++;
        }
        return dist;
    }
}