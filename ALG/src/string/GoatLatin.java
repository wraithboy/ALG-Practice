package string;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin(String S) {

        Set<Character> vowel = new HashSet<Character>();

        vowel.add('a');
        vowel.add('A');
        vowel.add('e');
        vowel.add('E');
        vowel.add('i');
        vowel.add('I');
        vowel.add('O');
        vowel.add('o');
        vowel.add('u');
        vowel.add('U');

        int t=1;

        StringBuilder ans = new StringBuilder();

        for(String word:S.split(" "))
        {
            char first=S.charAt(0);

            if(vowel.contains(first))
            {
                ans.append(word);
            }
            else
            {
                ans.append(word.substring(1));
                ans.append(first);
            }

            ans.append("ma");

            for(int i=0;i<t;i++)
            {
                ans.append("a");
            }

            t++;
            ans.append(" ");
        }

        return ans.toString().trim();
    }
}
