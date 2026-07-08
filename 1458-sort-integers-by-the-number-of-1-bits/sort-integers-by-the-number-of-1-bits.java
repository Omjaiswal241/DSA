class Solution {
    public int[] sortByBits(int[] arr) {
        Integer res[]=new Integer[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            res[i]=arr[i];
        }
        Arrays.sort(res,(a,b)->
        {
            int countA=Integer.bitCount(a);
            int countB=Integer.bitCount(b);
            if(countA==countB)
            {
                return a-b;
            }
            return countA-countB;
        });
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=res[i];
        }
        return arr;
    }
}