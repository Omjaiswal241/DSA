class Solution {
    int N;
    int directions[][]={{-1,0},{0,-1},{1,0},{0,1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        N=grid.size();
        Queue<int[]> qu=new ArrayDeque<>();
        boolean visited[][]=new boolean[N][N];
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(grid.get(i).get(j)==1)
                {
                    qu.add(new int[]{i,j});
                    visited[i][j]=true;
                }
            }
        }
        int distnearthief[][]=new int[N][N];
        int level=0;
        while(qu.size()!=0)
        {
            int size=qu.size();
            while(size-- >0)
            {
                int curr[]=qu.remove();
                int row=curr[0];
                int col=curr[1];
                distnearthief[row][col]=level;
                for(int dir[]:directions)
                {
                    int newrow=row+dir[0];
                    int newcol=col+dir[1];
                    if(newrow<0 || newcol<0 || newrow>=N || newcol>=N || visited[newrow][newcol])
                    {
                        continue;
                    }
                    qu.add(new int[]{newrow,newcol});
                    visited[newrow][newcol]=true;
                }
            }
            level++;
        }
        int low=0,high=N*N;
        int ans=0;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(check(distnearthief,mid))
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        return ans;
    }
    public boolean check(int distnearthief[][],int mid)
    {
        if(distnearthief[0][0]<mid)
        {
            return false;
        }
        Queue<int[]> qu=new ArrayDeque<>();
        qu.add(new int[]{0,0});
        boolean visited[][]=new boolean[N][N];
        visited[0][0]=true;
        while(qu.size()!=0)
        {
            int curr[]=qu.poll();
            int row=curr[0];
            int col=curr[1];
            if(row==N-1&& col==N-1)
            {
                return true;
            }
            for(int dir[]:directions)
            {
                int newrow=row+dir[0];
                int newcol=col+dir[1];
                if(newrow<0 || newcol<0 || newrow>=N || newcol>=N || visited[newrow][newcol])
                {
                    continue;
                }
                if(distnearthief[newrow][newcol]<mid)
                {
                    continue;
                }
                qu.add(new int[]{newrow,newcol});
                visited[newrow][newcol]=true;
            }
        }
        return false;
    }
}