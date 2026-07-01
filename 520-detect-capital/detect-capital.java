class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1)
        {
            return true;
        }
        boolean firstUpper=Character.isUpperCase(word.charAt(0));
        boolean secondUpper=Character.isUpperCase(word.charAt(1));
        for(int i=1;i<word.length();i++)
        {
            char x=word.charAt(i);
            if(firstUpper)
            {
                if(secondUpper)
                {
                    if(Character.isLowerCase(x))
                    {
                        return false;
                    }
                }
                else
                {
                    if(Character.isUpperCase(x))
                    {
                        return false;
                    }
                }
            }
            else
            {
                if(Character.isUpperCase(x))
                {
                    return false;
                }
            }
        }
        return true;
    }
}