class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->
        {
            if(a[0]==b[0])
            {
                return Integer.compare(b[1],a[1]);
            }
            else
            {
                return Integer.compare(a[0],b[0]);
            }
        });
        int cnt=0;
        int prev[]={0,0};
        for(int i=0;i<intervals.length;i++)
        {
            if(cnt==0)
            {
                cnt++;
                prev=intervals[0];
                continue;
            }
            while(i<intervals.length && prev[0]<=intervals[i][0] && intervals[i][1]<=prev[1])
            {
                i++;
            }
            if(i<intervals.length)
            {
                prev=intervals[i];
                cnt++;
            }
        }
        return cnt;
    }
}