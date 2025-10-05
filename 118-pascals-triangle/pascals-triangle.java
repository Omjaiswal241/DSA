class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(numRows==0)
        {
            return new ArrayList<List<Integer>>();
        }
        List<Integer> first=new ArrayList<>();
        first.add(1);
        res.add(first);
        for(int i=1;i<numRows;i++)
        {
            List<Integer> prev=res.get(i-1);
            List<Integer> li=new ArrayList<>();
            li.add(1);
            for(int j=0;j<i-1;j++)
            {
                li.add(prev.get(j)+prev.get(j+1));
            }
            li.add(1);
            res.add(li);
        }
        return res;
    }  
}