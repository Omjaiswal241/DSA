class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
        {
            return intervals;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res=new ArrayList<>();
        res.add(intervals[0]);
        int j=0;
        for(int i=1;i<intervals.length;i++)
        {
            int interval[]=res.get(j);
            if(intervals[i][0]<=interval[1])
            {
                interval[1]=Math.max(intervals[i][1],interval[1]);
            }
            else
            {
                res.add(intervals[i]);
                j++;
            }
        }
        int ar[][]=new int[j+1][2];
        for(int i=0;i<=j;i++)
        {
            ar[i]=res.get(i);
        }
        return ar;
    }
}