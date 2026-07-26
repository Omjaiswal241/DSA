class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n=bills.length;
        int i=0;
        int fives=0;
        int tens=0;
        while(i<n)
        {
            if(bills[i]==5)
            {
                fives++;
            }
            else if(bills[i]==10)
            {
                fives--;
                tens++;
                if(fives<0)
                {
                    return false;
                }
            }
            else
            {
                if(tens>0 && fives>0)
                {
                    tens--;
                    fives--;
                }
                else if(fives>=3)
                {
                    fives=fives-3;
                }
                else
                {
                    return false;
                }
            }
            i++;
        }
        return true;
    }
}