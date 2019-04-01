package string;

public class CustomSortString {

    public String customSortString(String S, String T) {

        StringBuilder sb = new StringBuilder();

        int[] map= new int[26];

        for(char c: T.toCharArray())
        {
            map[c-'a']++;
        }

        for(char c:S.toCharArray())
        {
            while(map[c-'a']>0)
            {
                sb.append(c);
                map[c-'a']--;
            }
        }

        for(char c:T.toCharArray())
        {
            while(map[c-'a']>0)
            {
                sb.append(c);
                map[c-'a']--;
            }
        }

        return sb.toString();

    }

}
