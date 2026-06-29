class Solution {
    public int numOfStrings(String[] patterns, String word) {
        HashSet<String> hs=new HashSet<>();
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<=n;j++)
            {
                hs.add(word.substring(i,j));
            }
        }
        int cnt=0;
        for(int i=0;i<patterns.length;i++)
        {
            if(hs.contains(patterns[i]))
            {
                cnt++;
            }
        }
        return cnt;
    }
}