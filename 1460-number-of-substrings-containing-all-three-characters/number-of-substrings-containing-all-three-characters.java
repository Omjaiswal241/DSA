class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        int temp[]=new int[3];
        int i=0,j=0;
        int res=0;
        while(j<n)
        {
            char x=s.charAt(j);
            if(x=='a')
            {
                temp[0]++;
            }
            else if(x=='b')
            {
                temp[1]++;
            }
            else if(x=='c')
            {
                temp[2]++;
            }
            if(temp[0]>0 && temp[1]>0 && temp[2]>0)
            {
                while(temp[0]>0 && temp[1]>0 && temp[2]>0)
                {
                res+=(n-j);
                char f=s.charAt(i);
                if(f=='a')
                {
                    temp[0]--;
                }
                else if(f=='b')
                {
                    temp[1]--;
                }
                else if(f=='c')
                {
                    temp[2]--;
                }
                i++;
                }
            }
            j++;
        }
        return res;
    }
}