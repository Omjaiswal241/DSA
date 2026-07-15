class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftsum=0;
        int n=cardPoints.length;
        for(int i=0;i<k;i++)
        {
            leftsum+=cardPoints[i];
        }
        int max=leftsum;
        int rightidx=n-1;
        int rightsum=0;
        for(int i=k-1;i>=0;i--)
        {
            leftsum=leftsum-cardPoints[i];
            rightsum+=cardPoints[rightidx];
            int sum=leftsum+rightsum;
            rightidx--;
            max=Math.max(max,sum);
        }
        return max;
    }
}