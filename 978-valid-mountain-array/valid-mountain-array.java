class Solution {
    public boolean validMountainArray(int[] ar) {
        int i=0;
        int n=ar.length;
        while(i+1<n && ar[i]<ar[i+1])
        {
            i++;
        }
        if(i==0 || i==n-1)
        {
            return false;
        }
        while(i+1<n && ar[i]>ar[i+1])
        {
            i++;
        }
        return i==n-1;
    }
}