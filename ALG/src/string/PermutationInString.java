package string;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        
        if(s2.length()<s1.length())
            return false;

        int[] dic = new int[26];
        int[] map = new int[26];

        int count=0;

        for(int i=0;i<s1.length();i++)
        {
            dic[s1.charAt(i)-'a']++;
        }

        for(int i=0;i<s2.length();i++)
        {
            if(i>=s1.length())
            {
                map[s2.charAt(i-s1.length())-'a']--;
            }

            map[s2.charAt(i)-'a']++;

            if(match(dic,map))
                return true;
        }

        return false;
    }

    private boolean match(int[] num1,int num2[])
    {
        for(int i=0;i<26;i++)
        {
            if(num1[i]!=num2[i])
                return false;
        }

        return true;
    }
}
