class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        HashMap<String,List<String>> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            String curr=strs[i];
            char arr[]=new char[curr.length()];
            for(int j=0;j<curr.length();j++)
            {
                arr[j]=curr.charAt(j);
            } 
            Arrays.sort(arr);
            String newstr=new String(arr);
            if(!hm.containsKey(newstr))
            {
                hm.put(newstr,new ArrayList<>());
            }
            hm.get(newstr).add(curr);
        }
        List<List<String>> res=new ArrayList<>();
        for(String key:hm.keySet())
        {
            res.add(hm.get(key));
        }
        return res;
    }
}