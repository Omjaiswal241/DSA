class Solution {
    public int[] sortByBits(int[] arr) {
        int n=arr.length;
        Integer[] res=new Integer[n];
        for(int i=0;i<arr.length;i++)
        {
            res[i]=arr[i];
        }
        Arrays.sort(res,(a,b)->{
        int counta=Integer.bitCount(a);
        int countb=Integer.bitCount(b);
        if(counta==countb)
        {
            return a-b;
        }
        return counta-countb;
    });
        for(int i=0;i<n;i++)
        {
            arr[i]=res[i];
        }
        return arr;
    }
}