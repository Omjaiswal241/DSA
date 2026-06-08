class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
       List<Integer> li1=new ArrayList<>();
       List<Integer> li2=new ArrayList<>();
       int f=0;
       for(int i:nums)
       {
        if(i<pivot)
        {
            li1.add(i);
        }
        else if(i==pivot)
        {
            f++;
        }
        else
        {
            li2.add(i);
        }
       } 
       int res[]=new int[nums.length];
       int i=0;
       int k=f;
       while(i<li1.size())
       {
        res[i]=li1.get(i);
        i++;
       }
       while(k>0)
       {
        res[i]=pivot;
        k--;
        i++;
       }
       int g=0;
       while(i<li1.size()+f+li2.size())
       {
        res[i]=li2.get(g);
        g++;
        i++;
       }
       return res;
    }
}