class Solution {
    public long smallestNumber(long num) {
        boolean sign=true;
        if(num<0)
        {
            sign=false;
        }
        num=Math.abs(num);
        ArrayList<Long> li=new ArrayList<>();
        while(num>0)
        {
            long d=num%10;
            li.add(d);
            num=num/10;
        }
        if(li.size()==1)
        {
            return (sign)?li.get(0):-li.get(0);
        }
        if(sign)
        {
            Collections.sort(li);
            int f=0,g=0;
            while(g<li.size() && li.get(g)==0)
            {
                g++;
            }
            if(g>0)
            {
                li.set(0,li.get(g));
                li.set(g,(long)0);
            }
        }
        else
        {
            Collections.sort(li,Collections.reverseOrder());     
        }
        long r=0;
        for(int i=0;i<li.size();i++)
        {
            r=r*10+li.get(i);
        }
        return (sign)?r:-r;
    }
}