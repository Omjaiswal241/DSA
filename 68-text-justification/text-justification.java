class Solution {
    int MAX_WIDTH;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res=new ArrayList<>();
        MAX_WIDTH=maxWidth;
        int n=words.length;
        int i=0;
        while(i<n)
        {
            int lettercnt=words[i].length();
            int gaddhe=0;
            int j=i+1;
            while(j<n && lettercnt+words[j].length()+gaddhe+1<=maxWidth)
            {
                lettercnt+=words[j].length();
                gaddhe++;
                j++;
            }
            int remaining=maxWidth-lettercnt;
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
    public String addString(String [] words,int i,int j,int space,int extraspace)
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
            if(extraspace-->0)
            {
                sb.append(" ");
            }
        }
        while(sb.length()<MAX_WIDTH)
        {
            sb.append(" ");
        }
        return sb.toString();
    }
}