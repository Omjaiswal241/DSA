class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> li=new ArrayList<>();
        int n=intervals.length;
        li.add(intervals[0]);
        int j=0;
        for(int i=1;i<intervals.length;i++)
        {
            int interval[]=li.get(j);
            if(interval[1]>=intervals[i][0])
            {
                interval[1]=Math.max(interval[1],intervals[i][1]);
            }
            else
            {
                li.add(intervals[i]);
                j++;
            }
        }
        int res[][]=new int[li.size()][2];
        for(int i=0;i<li.size();i++)
        {
            res[i]=li.get(i);
        } 
        return res;
    }
}