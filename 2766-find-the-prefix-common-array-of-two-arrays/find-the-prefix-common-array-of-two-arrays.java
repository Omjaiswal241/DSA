class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int res[]=new int[n];
        int temp[]=new int[n+1];
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            temp[A[i]]++;
            temp[B[i]]++;
            if(A[i]==B[i])
            {
                cnt=cnt+1;
            }
            else 
            {
            if(temp[A[i]]==2)
            {
                cnt=cnt+1;
            }
            if(temp[B[i]]==2)
            {
                cnt=cnt+1;
            }
            }
            res[i]=cnt;
        }
        return res;
    }
}