class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<Integer> hs=substring(s,k);
        for(int i=0;i<(int)Math.pow(2,k);i++)
        {
            if(!hs.contains(i))
            {
                return false;
            }
        }
        return true;
    }
    public HashSet<Integer> substring(String s,int k)
    {
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<=s.length()-k;i++)
        {
            hs.add(Integer.parseInt(s.substring(i,i+k),2));
        }
        return hs;
    }
}