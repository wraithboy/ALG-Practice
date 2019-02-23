package BFS;

import java.util.*;

public class WorldLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

       Set<String> dictionary = new HashSet<>();

       for( String word: wordList)
       {
           dictionary.add(word);
       }

       if(!dictionary.contains(endWord))
       {
           return 0;
       }

       Queue<String> queue = new LinkedList<>();

       int step=0;

       queue.add(beginWord);

       while(!queue.isEmpty())
       {
           step++;
           int size = queue.size();

           for(int i=0;i<size;i++)
           {
                String curr=queue.poll();
                for(int j=0;j<curr.length();j++)
                {
                    char[] chs = curr.toCharArray();
                    for(char k='a';k<='z';k++)
                    {
                        chs[j]=k;
                        String s = new String(chs);
                        if(s.equals(endWord))
                            return step+1;
                        if(!dictionary.contains(s))
                            continue;

                        dictionary.remove(s);

                        queue.add(s);
                    }
                }
           }
       }

       return 0;

    }


    public int ladderLengthBiDirectional(String beginWord, String endWord, List<String> wordList)
    {

        Set<String> dictionary = new HashSet<String>();

        for(String word:wordList)
        {
            dictionary.add(word);
        }

        if(!dictionary.contains(endWord))
        {
            return 0;
        }

        Set<String>  q1 = new HashSet<>();
        Set<String>  q2 = new HashSet<>();

        q1.add(beginWord);
        q2.add(endWord);

        int step=0;


        while(!q1.isEmpty() || !q2.isEmpty())
        {
            step++;
            if(q1.size()>q2.size())
            {
                Set<String> q = q1;
                q1=q2;
                q1=q;
            }

            Set<String> q = new HashSet<>();

            for(String str : q1)
            {

                for(int j=0;j<str.length();j++) {
                    char[] chs = str.toCharArray();

                    for (char k = 'a'; k < 'z'; k++) {
                        chs[j] = k;
                        String s = new String(chs);
                        if (q2.contains(s))
                            return step + 1;

                        if (!dictionary.contains(s))
                            continue;

                        dictionary.remove(s);

                        q.add(s);
                    }
                }
            }
            q1=q;
        }

        return 0;
    }



}
