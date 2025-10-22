class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> li=new ArrayList<Integer>();
      for(int i=1;i<=9;i++)
      {
        solve(i,n,li);
      }  
      return li;
    }
    public static void solve(int num,int n,List<Integer> li)
    {
        if(num>n)
        {
            return;
        }
        li.add(num);
        for(int digit=0;digit<=9;digit++)
        {
            int newnum=num*10+digit;
            if(newnum<=n)
            {
                solve(newnum,n,li);
            }
        }
    }
}