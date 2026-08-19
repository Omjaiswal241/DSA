class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        for(int curr[]:reservedSeats)
        {
            if(!hm.containsKey(curr[0]))
            {
                hm.put(curr[0],new HashSet<>());
            }
            hm.get(curr[0]).add(curr[1]);
        }
        int res=(n-hm.size())*2;
        for(int key:hm.keySet())
        {
            HashSet<Integer> hs=hm.get(key);
            boolean left=!hs.contains(2) && !hs.contains(3) && !hs.contains(4) && !hs.contains(5);
            boolean middle=!hs.contains(4) && !hs.contains(5) && !hs.contains(6) && !hs.contains(7);
            boolean right=!hs.contains(6) && !hs.contains(7) && !hs.contains(8) && !hs.contains(9);
            if(left && right)
            {
                res+=2;
            }
            else if(left || middle || right)
            {
                res++;
            }
        }
        return res;
    }
}