class Solution {
    int N;
    int directions[][]={{1,0},{-1,0},{0,1},{0,-1}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        N=grid.size();
        int [][]distNearestThief=new int[N][N];
        Queue<int[]> qu=new LinkedList<>();
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
        int level=0;
        while(qu.size()>0)
        {
            int size=qu.size();
            while(size-- >0)
            {
                int temp[]=qu.remove();
                int row=temp[0];
                int col=temp[1];
                distNearestThief[row][col]=level;
                for(int dir[]:directions)
                {
                    int newrow=dir[0]+row;
                    int newcol=dir[1]+col;
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
        int res=0;
        int l=0,h=400;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(check(distNearestThief,mid))
            {
                res=mid;
                l=mid+1;
            }
            else
            {
                h=mid-1;
            }
        }
        return res;
    }

    public boolean check(int [][]distNearestThief,int mid)
    {
        Queue<int[]> qu=new LinkedList<>();
        boolean visited[][]=new boolean[N][N];
        qu.add(new int[]{0,0});
        visited[0][0]=true;
        if(distNearestThief[0][0]<mid)
        {
            return false;
        }
        while(qu.size()>0)
        {
            int curr[]=qu.remove();
            int row=curr[0];
            int col=curr[1];

            if(row==N-1 && col==N-1)
            {
                return true;
            }
            for(int dir[]:directions)
            {
                int newrow=dir[0]+row;
                int newcol=dir[1]+col;
                if(newrow<0 || newcol<0 || newrow>=N || newcol>=N || visited[newrow][newcol])
                {
                    continue;
                }
                if(distNearestThief[newrow][newcol]<mid)
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