class Solution {
    public String convertToBase7(int num) {
        boolean sign=true;
        if(num<0)
        {
            sign=false;
        }
        else if(num==0)
        {
            return "0";
        }
        num=Math.abs(num);
        String s="";
        while(num>0)
        {
            int quo=num%7;
            int rem=num/7;
            s=quo+s;
            num=rem;
        }
        return (sign)?s:"-"+s;
    }
}