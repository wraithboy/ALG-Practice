package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class test {

    public static void main(String args[])
    {
        String[] s= {"steak","the", "hello", "word", "teaks", "tseak"};

        test t =new test();

        System.out.println(t.find(Arrays.asList(s),"steak"));

    }

    public List<String> find(List<String> list, String target)
    {
        List<String> result = new ArrayList<>();

        int[] freqmap= new int[56];

        int[] targetmap=new int[56];

        for(char c : target.toCharArray())
        {
            freqmap[c-'a']++;
        }

        for(String s : list)
        {
            for(char c:s.toCharArray())
            {
                targetmap[c-'a']++;
            }

            if(isValid(freqmap,targetmap))
                result.add(s);

            Arrays.fill(targetmap,0);
        }

        return result;
    }

    public boolean isValid(int[] freqmap,int[] targetmap)
    {
        for(int i=0;i<freqmap.length;i++)
        {
            if(freqmap[i]!=targetmap[i])
                return false;
        }

        return true;
    }

}
