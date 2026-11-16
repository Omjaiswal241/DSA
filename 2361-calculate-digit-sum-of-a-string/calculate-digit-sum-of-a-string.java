class Solution {
    public String digitSum(String s, int k) {
        while(s.length()>k)
        {
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<=Math.min(s.length()-1,i);i=i+k)
            {
                int sum=0;
                for(int j=i;j<Math.min(i+k,s.length());j++)
                {
                    char x=s.charAt(j);
                    sum+=Integer.parseInt(x+"");
                }
                sb.append(sum);
            }
            s=sb.toString();
        }
        return s;
    }
}