class Solution {
    public int minimumPushes(String word) {
    int n=word.length();
    int a=n/8;
    int res=0;
    int f=1;
    for(int i=1;i<=a;i++)
    {
        res+=i*8;
    }
    return res+(n%8)*(a+1);
    }
}