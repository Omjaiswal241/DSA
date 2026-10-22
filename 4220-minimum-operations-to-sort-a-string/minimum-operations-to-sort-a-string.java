class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char ar[]=new char[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=s.charAt(i);
        }
        boolean sorted=true;
        for(int i=1;i<n;i++)
        {
            if(ar[i]<ar[i-1])
            {
                sorted=false;
                break;
            }
        }
        if(sorted)
        {
            return 0;
        }
        if(n==2)
        {
            return -1;
        }
        char min=ar[0],max=ar[0];
        for(int i=0;i<n;i++)
        {
            if(ar[i]<min)
            {
                min=ar[i];
            }
            if(ar[i]>max)
            {
                max=ar[i];
            }
        }
        if(ar[0]==min || ar[n-1]==max)
        {
            return 1;
        }
        char min_in=ar[1],max_in=ar[1];
        for(int i=1;i<n-1;i++)
        {
            if(min_in>ar[i])
            {
                min_in=ar[i];
            }
            if(max_in<ar[i])
            {
                max_in=ar[i];
            }
        }
        if(ar[0]>max_in && ar[n-1]<min_in)
        {
            return 3;
        }
        return 2;
    }
}