class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int i=0,j=0;
        int currsum=0;
        int minlenbefore[]=new int[n];
        Arrays.fill(minlenbefore,Integer.MAX_VALUE);
        int res=Integer.MAX_VALUE;
        int bestmin=Integer.MAX_VALUE;
        while(j<n)
        {
            currsum+=arr[j];
            while(currsum>target)
            {
                currsum-=arr[i];
                i++;
            }
            if(currsum==target)
            {
                int len=j-i+1;
                if(i>0 && minlenbefore[i-1]!=Integer.MAX_VALUE)
                {
                    res=Math.min(res,(len+minlenbefore[i-1]));
                }
                bestmin=Integer.min(bestmin,len);
            }
            minlenbefore[j]=bestmin;
            j++;
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}