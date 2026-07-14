class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        int n=fruits.length;
        int j=0;
        int maxlen=0;
        for(int i=0;i<n;i++)
        {
            hm.put(fruits[i],hm.getOrDefault(fruits[i],0)+1);
            if(hm.size()>2)
            {
                while(hm.size()>2)
                {
                    int a=hm.get(fruits[j])-1;
                    hm.put(fruits[j],a);
                    if(a==0)
                    {
                        hm.remove(fruits[j]);
                    }
                    j++;
                }
            }
            else if(hm.size()<=2)
            {
                maxlen=Math.max(maxlen,i-j+1);
            }
        }
        return maxlen;
    }
}