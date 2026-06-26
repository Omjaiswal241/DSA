class Solution {
    public int mirrorDistance(int n) {
        int rev=0;
        for(int i=n;i>0;i=i/10)
        {
            int d=i%10;
            rev=rev*10+d;
        }
        return Math.abs(rev-n);
    }
}