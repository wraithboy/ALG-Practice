package string;

public class ValidWordAbbreviation {

    public boolean validWordAbbreviation(String word, String abbr) {

        if(word==null || word.length()==0 || abbr==null || abbr.length()==0)
            return false;

        int i=0,j=0;

        while(i<word.length() && j<abbr.length())
        {
            if(word.charAt(i)==abbr.charAt(j))
            {
                i++;
                j++;
                continue;
            }

            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }

            int start=j;

            while(j<abbr.length() && Character.isDigit(abbr.charAt(j)))
            {
                j++;
            }

            int len=Integer.valueOf(abbr.substring(start,j));
            i=i+len;

        }

        if(i==word.length() && j==abbr.length())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
}
