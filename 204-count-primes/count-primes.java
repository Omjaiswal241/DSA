class Solution {
    public int countPrimes(int n) {
        if(n<=2)
        {
            return 0;
        }
        int prime[]=new int [n];
        Arrays.fill(prime,1);
        for(int i=4;i<n;i=i+2)
        {
            prime[i]=0;
        }
        int limit=(int)Math.sqrt(n);
        for(int i=3;i<=limit;i=i+2)
        {
            if(prime[i]==1)
            {
                int f=i;
                for(int j=i*i;j<n;j=i*f)
                {
                    prime[j]=0;
                    f=f+2;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++)
        {
            if(prime[i]==1)
            {
                cnt++;
            }
        }
        return cnt;
    }
}