class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five_curr=0;
        int ten_curr=0;
        for(int i:bills)
        {
            if(i==5)
            {
                five_curr++;
            }
            else if(i==10)
            {
                if(five_curr>0)
                {
                    five_curr--;
                    ten_curr++;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if(five_curr>0 && ten_curr>0)
                {
                    five_curr--;
                    ten_curr--;
                }
                else if(five_curr>2)
                {
                    five_curr-=3;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;
    }
}