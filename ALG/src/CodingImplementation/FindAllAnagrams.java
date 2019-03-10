package CodingImplementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindAllAnagrams {

    public static void main(String args[])
    {
        FindAllAnagrams f  = new FindAllAnagrams();

        f.findAnagrams("cbaebabacd","abc");
    }

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<>();

        if(s==null || p==null || s.length()==0 || p.length()==0)
            return result;

        int[] target=new int[256];
        int[] source=new int[256];

        for(char c: p.toCharArray())
        {
            target[c-'a']++;
        }

        int count=0;


        for(int i=0,j=0;i<s.length();i++) {


            if(target[s.charAt(i)-'a']!=0)
            {
                if(source[s.charAt(i)-'a']<target[s.charAt(i)-'a'])
                    count++;

                source[s.charAt(i)-'a']++;

            }

            if(i<p.length()-1)
                continue;

            if(count==p.length())
            {
                result.add(j);
            }

            System.out.println("count: "+count+" "+i);

            if(target[s.charAt(j)-'a']!=0)
            {
                if(source[s.charAt(j)-'a']<=target[s.charAt(j)-'a'])
                    count--;
                source[s.charAt(j)-'a']--;
            }
            j++;
        }

        return result;
    }
}
