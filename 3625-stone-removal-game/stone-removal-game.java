class Solution {
    public boolean canAliceWin(int n) {
        int i=10;
        boolean alice_chance=true;
        while(n>=i)
        {
            n=n-i;
            i--;
            alice_chance=!(alice_chance);
        }
        return (alice_chance==false)?true:false;
    }
}