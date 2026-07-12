class Solution {
    public int countPrimes(int n) {
        if(n<2)
        {
            return 0;
        }
        else if(n==3)
        {
            return 1;
        }
        int temp[]=new int[n];
        Arrays.fill(temp,1);
        int limit=(int)Math.sqrt(n);
        for(int i=2;i<=limit;i++)
        {
            if(i==2 || i%2==1)
            {
                int f=i;
                for(int j=i*i;j<n;j=i*f)
                {
                    temp[j]=0;
                    if(i==2)
                    {
                        f++;
                        continue;
                    }
                    f=f+2;
                }
            }
        }
        int cnt=0;
        for(int i=2;i<n;i++)
        {
            if(temp[i]==1)
            {
                cnt++;
            }
        }
        return cnt;
    }
}