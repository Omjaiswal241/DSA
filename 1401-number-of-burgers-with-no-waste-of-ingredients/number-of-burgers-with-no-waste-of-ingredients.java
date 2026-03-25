class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> li=new ArrayList<>();
        if(tomatoSlices%2==1)
        {
            return li;
        }
        int large=(tomatoSlices-cheeseSlices*2)/2;
        int small=cheeseSlices-large;
        if(large<0 || small<0)
        {
            return li;
        }
        li.add(large);
        li.add(small);
        return li;
    }
}