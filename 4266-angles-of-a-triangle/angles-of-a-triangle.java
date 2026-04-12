class Solution {
    public double[] internalAngles(int[] sides) {
        double a=sides[0];
        double b=sides[1];
        double c=sides[2];
        if(a+b<=c || a+c<=b || b+c<=a)
        {
            return new double[0];
        }
        double ans[]=new double[3];
        ans[0]=Math.toDegrees(Math.acos((b*b+c*c-a*a)/(2*b*c)));
        ans[1]=Math.toDegrees(Math.acos((a*a+c*c-b*b)/(2*a*c)));
        ans[2]=Math.toDegrees(Math.acos((b*b+a*a-c*c)/(2*b*a)));
        Arrays.sort(ans);
        return ans;
    }
}