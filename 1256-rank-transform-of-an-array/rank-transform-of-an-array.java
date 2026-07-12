class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int res[]=new int[n];
        TreeMap<Integer,List<Integer>> tm=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            List<Integer> li=tm.getOrDefault(arr[i],new ArrayList<>());
            li.add(i);
            tm.put(arr[i],li);
        }
        int f=1;
        for(int key:tm.keySet())
        {
            for(int j=0;j<tm.get(key).size();j++)
            {
                res[tm.get(key).get(j)]=f;
            }
            f++;
        }
        return res;
    }
}