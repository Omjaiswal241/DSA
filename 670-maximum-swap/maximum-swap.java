class Solution {
    public int maximumSwap(int num) {
        String str=num+"";
        int n=str.length();

        char [] digit=new char[n];
        for(int i=0;i<n;i++)
        {
            digit[i]=str.charAt(i);
        }

        int idx[]=new int[n];
        idx[n-1]=n-1;
        int max=n-1;
        for(int i=n-2;i>=0;i--)
        {
            if(digit[i]>digit[max])
            {
                max=i;
            }
            idx[i]=max;
        }

        for(int i=0;i<n-1;i++)
        {
            if(digit[i]!=digit[idx[i]])
            {
                char temp=digit[i];
                digit[i]=digit[idx[i]];
                digit[idx[i]]=temp;
                return Integer.parseInt(new String(digit));
            }
        }
        return num;
    }
}