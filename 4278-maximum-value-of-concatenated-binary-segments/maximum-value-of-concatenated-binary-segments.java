class Solution {
    public int maxValue(int[] nums1, int[] nums0) {
        int n=nums1.length;
        List<String> li=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<nums1[i];j++)
            {
                sb.append('1');
            }
            for(int j=0;j<nums0[i];j++)
            {
                sb.append('0');
            }
            li.add(sb.toString());
        }
        Collections.sort(li,(a,b)->(b+a).compareTo(a+b));
        long res=0;
        for(String s:li)
        {
            for(int i=0;i<s.length();i++)
            {
                res=(res*2 + (s.charAt(i)-'0'))%1000000007;
            }
        }
        return (int)res;
    }
}