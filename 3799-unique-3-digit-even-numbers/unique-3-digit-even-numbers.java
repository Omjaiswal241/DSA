class Solution {
    public int totalNumbers(int[] digits) {
        int cnt=0;
        int n=digits.length;
        int freq[]=new int[10];
        for(int i=0;i<n;i++)
        {
            freq[digits[i]]++;
        }
        for(int i=1;i<=9;i++)
        {
            if(freq[i]==0)
            {
                continue;
            }
            freq[i]--;
            for(int j=0;j<=9;j++)
            {
                if(freq[j]==0)
                {
                    continue;
                }
                freq[j]--;
                for(int k=0;k<=8;k=k+2)
                {
                    if(freq[k]==0)
                    {
                        continue;
                    }
                    freq[k]--;
                    cnt++;
                    freq[k]++;
                }
                freq[j]++;
            }
            freq[i]++;
        }
        return cnt;
    }
}