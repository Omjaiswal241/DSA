class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num*9<sum)
        {
            return "";
        }
        int nines=sum/9;
        int rem=sum%9;
        StringBuilder sb=new StringBuilder();
        while(nines>0)
        {
            sb.append("9");
            nines--;
        }
        if(rem>0)
        {
            sb.append(rem);
        }
        while(sb.length()<num)
        {
            sb.append("0");
        }
        return sb.toString();
    }
}