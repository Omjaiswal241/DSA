class Solution {
    int MAXWIDTH;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        MAXWIDTH=maxWidth;
        int n=words.length;
        int i=0;
        while(i<n)
        {
            int lettercount=words[i].length();
            int j=i+1;
            int gaddhe=0;
            while(j<n && lettercount+words[j].length()+gaddhe+1<=maxWidth)
            {
                lettercount+=words[j].length();
                gaddhe++;
                j++;
            }
            int remaining=maxWidth-lettercount;
            int space=(gaddhe==0)?0:remaining/gaddhe;
            int extraspace=(gaddhe==0)?0:remaining%gaddhe;
            if(j==n)
            {
                space=1;
                extraspace=0;
            }
            res.add(addString(words,i,j,space,extraspace));
            i=j;
        }
        return res;
    }
    public String addString(String words[],int i,int j,int space,int extraspace)
    {
        StringBuilder sb=new StringBuilder();
        for(int f=i;f<j;f++)
        {
            sb.append(words[f]);
            if(f==j-1)
            {
                continue;
            }
            for(int s=space;s>0;s--)
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