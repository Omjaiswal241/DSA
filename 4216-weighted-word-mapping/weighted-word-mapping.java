class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        int n=words.length;
        String res="";
        for(int i=0;i<n;i++)
        {
            String s=words[i];
            int temp=0;
            for(int j=0;j<s.length();j++)
            {
                char x=s.charAt(j);
                int num=x-'a';
                temp+=weights[num];
            }
            int f=25-(temp%26);
            char g=(char)(97+f);
            res+=g;
        }
        return res;
    }
}