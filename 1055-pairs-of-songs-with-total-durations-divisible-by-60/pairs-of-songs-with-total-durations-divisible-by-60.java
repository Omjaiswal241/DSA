class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int freq[]=new int[60];
        int count=0;
        for(int i:time)
        {
            int f=(i%60);
            int remaining=(f!=0)?(60-f):0;
            count+=freq[remaining];
            freq[f]++;
        }
        return count;
    }
}