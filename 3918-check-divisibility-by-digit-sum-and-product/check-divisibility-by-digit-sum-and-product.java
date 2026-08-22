class Solution {
    public boolean checkDivisibility(int n) {
        int res[]=helper(n);
        return n%(res[0]+res[1])==0;
    }
    public int[] helper(int n)
    {
        int sum=0;
        int prod=1;
        while(n>0)
        {
            int d=n%10;
            sum+=d;
            prod*=d;
            n=n/10;
        }
        return new int[]{sum,prod};
    }
}