class Solution {
    public int countSegments(String s) {
        s=s.trim();
        if(s.equals(""))
        {
            return 0;
        }
        String ar[]=s.split("\\s+");
        return ar.length;
    }
}