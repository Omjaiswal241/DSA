class Solution {
    int MAXWIDTH;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        int i=0;
        int n=words.length;
        MAXWIDTH=maxWidth;
        while(i<n)
        {
            int letterscount=words[i].length();
            int gaddhe=0;
            int j=i+1;
            while(j<n && letterscount+gaddhe+words[j].length()+1<=maxWidth)
            {
                letterscount+=words[j].length();
                gaddhe++;
                j=j+1;
            }
            int remaining=maxWidth-letterscount;
            int extrawordspace=(gaddhe==0)?0:remaining/gaddhe;
            int extraspace=(gaddhe==0)?0:remaining%gaddhe;
            if(j==n)
            {
                extrawordspace=1;
                extraspace=0;
            }
            res.add(getString(i,j,extrawordspace,extraspace,words));
            i=j;
        }
        return res;
    }
    public String getString(int i,int j,int extrawordspace,int extraspace,String []words)
    {
        StringBuilder sb=new StringBuilder();
        for(int k=i;k<j;k++)
        {
            sb.append(words[k]);
            if(k==j-1)
            {
                continue;
            }
            for(int f=1;f<=extrawordspace;f++)
            {
                sb.append(" ");
            }
            if(extraspace>0)
            {
                sb.append(" ");
                extraspace--;
            }
        }
        while(sb.length()<MAXWIDTH)
        {
            sb.append(" ");
        }
        return sb.toString();
    }
}