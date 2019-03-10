package CodingImplementation;

public class VerifyingAnAlienDictionary {

    int[] rank=new int[26];

    public boolean isAlienSorted(String[] words, String order)
    {
        for(int i=0;i<26;i++)
        {
            rank[order.charAt(i)-'a']=i;
        }

        for(int i=1;i<words.length;i++)
        {
            String word1=words[i-1];
            String word2=words[i];

            if(compare(word1,word2)>0)
                return false;
        }

        return true;
    }


    int compare(String s1,String s2)
    {
        int cmp=0;
        for(int i=0,j=0;i<s1.length()&&j<s2.length() && cmp==0;i++,j++)
        {
            cmp=rank[s1.charAt(i)]-rank[s2.charAt(j)];
        }

        return cmp==0 ? s1.length()-s2.length():cmp;
    }
}
