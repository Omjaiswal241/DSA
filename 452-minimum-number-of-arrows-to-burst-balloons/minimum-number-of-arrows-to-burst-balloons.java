class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int ans=0;
        int i=0;
        int n=points.length;
        while(i<n)
        {
            int cover=points[i][1];
            i++;
            ans++;
            while(i<n && cover>=points[i][0])
            {
                i++;
            }
        }
        return ans;
    }
}