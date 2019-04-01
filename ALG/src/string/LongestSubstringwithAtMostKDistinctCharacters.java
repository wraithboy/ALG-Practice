package string;

public class LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0)
        {
            return 0;
        }

        int[] map = new int[26];

        int left=0;
        int max=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {

            if(map[s.charAt(i)]++==0)
            {
                count++;
            }

            if(count>2)
            {
                while(count>2)
                {
                    if(--map[s.charAt(left)]==0)
                        count--;
                    left++;
                }
            }

            max=Math.max(max,i-left+1);
        }

        return left;

    }
}
