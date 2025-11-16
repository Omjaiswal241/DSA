class Solution {
    public int numSub(String s) {
        long ans=0,count=0;
        long mod = 1000000007;
        for(int i=0;i<s.length();i++)
        {
            char x=s.charAt(i);
            if(x=='1')
            {
                count++;
            }
            else
            {
                ans+=((count*(count+1))/2)%mod;
                count=0;
            }
        }
        ans+=((count*(count+1))/2)%mod;
        return (int)ans;
    }
}