class Solution {
    int n;
    int nextidx[];
    Node dp[][];
    class Node
    {
        long score=-1;
        List<Integer> idxs=new ArrayList<>();
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        n=intervals.size();
        for(int i=0;i<n;i++)
        {
            intervals.get(i).add(i);
        }
        Collections.sort(intervals,(a,b)->
        {
            if(a.get(0)!=b.get(0))
            {
                return Integer.compare(a.get(0),b.get(0));
            }
            else if(a.get(1)!=b.get(1))
            {
                return Integer.compare(a.get(1),b.get(1));
            }
            else if(a.get(2)!=b.get(2))
            {
                return Integer.compare(a.get(2),b.get(2));
            }
            return Integer.compare(a.get(3),b.get(3));
        });
        nextidx=new int[n];
        for(int i=0;i<n;i++)
        {
            int r=intervals.get(i).get(1);
            nextidx[i]=findNext(r,intervals);
        }
        int K=4;
        dp=new Node[n][K+1];
        for(int i=0;i<n;i++)
        {
            for(int k=0;k<=K;k++)
            {
                dp[i][k]=new Node();
            }
        }
        Node res=solve(0,K,intervals);
        int ans[]=new int[res.idxs.size()];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=res.idxs.get(i);
        }
        return ans;
    }
    public int findNext(int r,List<List<Integer>> intervals)
    {
        int low=0;
        int high=n-1;
        int res=n;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(intervals.get(mid).get(0)>r)
            {
                res=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return res;
    }
    public Node solve(int i,int K,List<List<Integer>> intervals)
    {
        if(K==0 || i>=n)
        {
            return new Node();
        }
        if(dp[i][K].score!=-1)
        {
            return dp[i][K];
        }
        int wt=intervals.get(i).get(2);
        int idx=intervals.get(i).get(3);
        int j=nextidx[i];
        
        Node skip=solve(i+1,K,intervals);

        Node temp=solve(j,K-1,intervals);
        Node take=new Node();
        take.score=temp.score+wt;
        take.idxs=new ArrayList<>(temp.idxs);
        take.idxs.add(idx);
        Collections.sort(take.idxs);

        Node res;
        if(skip.score>take.score)
        {
            res=skip;
        }
        else if(skip.score<take.score)
        {
            res=take;
        }
        else
        {
            res=isLexSmaller(skip.idxs,take.idxs)?skip:take;
        }
        return dp[i][K]=res;
    }
    public boolean isLexSmaller(List<Integer> a,List<Integer> b)
    {
        int size=Math.min(a.size(),b.size());
        for(int i=0;i<size;i++)
        {
            if(a.get(i)!=b.get(i))
            {
                return a.get(i)<b.get(i);
            }
        }
        return a.get(size)<b.get(size);
    }
}