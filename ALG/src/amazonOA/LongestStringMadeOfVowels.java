package amazonOA;

public class LongestStringMadeOfVowels {

    public static void main(String args[]) {
        String[] testcases = {"earthproblem", "letsgosomewhere", "aaayyyaayyayaaayayaaa"};
        for (String testcase : testcases)
            System.out.println(testcase + ": " + LongestStrOfVowels(testcase));
    }

    public static int LongestStrOfVowels(String s) {

        int len=s.length();

        int start=0;
        int end=len-1;

        int count=0;

        while(start<len && isVowel(s.charAt(start)))
        {
            start++;
            count++;
        }
        while(end>=0 && isVowel(s.charAt(end))) {
            end--;
            count++;
        }

        if(start>=len) return len;

        int res=0;
        int longest=0;
        for(int i=start;i<=end;i++)
        {
            if(isVowel(s.charAt(i)))
            {
                res++;
            }
            else
            {
                longest=Math.max(longest,res);
                res=0;
            }
        }

        return count+longest;
    }

    private static boolean isVowel(char c)
    {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u';
    }

}
