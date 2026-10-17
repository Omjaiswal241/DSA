class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> li=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            li.add(nums[i]);
        }
        Collections.sort(li,(a,b)->
        {
            int num1=solve(a);
            int num2=solve(b);
            if(num1!=num2)
            {
                return Integer.compare(num1,num2);
            }
            return Integer.compare(a,b);
        });
        HashMap<Integer,Integer> hm=new HashMap<>();
        int swaps=0;
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i],i);
        }
        for(int i=0;i<n;i++)
        {
            int pos=hm.get(li.get(i));
            if(pos!=i)
            {
                int curr=nums[i];
                nums[i]=nums[pos];
                nums[pos]=curr;

                hm.put(nums[i],i);
                hm.put(nums[pos],pos);
                swaps++;
            }
        }
        return swaps;
    }
    public int solve(int i)
    {
        int sum=0;
        while(i>0)
        {
            int d=i%10;
            sum+=d;
            i=i/10;
        }
        return sum;
    }
}