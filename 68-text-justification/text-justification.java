class Solution {
    int MAX_WIDTH;
    int n;
    public List<String> fullJustify(String[] words, int maxWidth) {
        n=words.length;
        MAX_WIDTH=maxWidth;
        int i=0;
        List<String> li=new ArrayList<>();
        while(i<n)
        {
            int lettercount=words[i].length();
            int gaddhe=0;
            int j=i+1;
            while(j<n && lettercount+words[j].length()+gaddhe+1<=MAX_WIDTH)
            {
                lettercount+=words[j].length();
                gaddhe+=1;
                j++;
            }
            int remaining=MAX_WIDTH-lettercount;
            int space=gaddhe==0?0:remaining/gaddhe;
            int extraspace=gaddhe==0?0:remaining%gaddhe;
            if(j==n)
            {
                space=1;
                extraspace=0;
            }
            li.add(solve(words,i,j,space,extraspace));
            i=j;
        }
        return li;
    }
    public String solve(String words[],int i,int j,int space,int extraspace)
    {
        StringBuilder sb=new StringBuilder();
        for(int f=i;f<j;f++)
        {
            sb.append(words[f]);
            if(f!=j-1)
            {
                for(int spaces=space;spaces>0;spaces--)
                {
                    sb.append(" ");
                }
                if(extraspace-->0)
                {
                    sb.append(" ");
                }
            }
        }
        while(sb.length()<MAX_WIDTH)
        {
            sb.append(" ");
        }
        return sb.toString();
    }
}