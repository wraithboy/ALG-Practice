package bfs;

import java.util.*;

public class WordLadderII {


    public static void main(String args[])
    {

        String[] list = new String[]{"hot","dot","dog","lot","log","cog"};

        ArrayList<String> s = new ArrayList<String>();

        for(int i=0;i<list.length;i++)
        {
            s.add(list[i]);
        }

        List<List<String>> result = findLadders("hit","cog",s);
        System.out.println(result);
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> dictionary = new HashSet<>();

        for(String word: wordList)
        {
            dictionary.add(word);
        }

        if(!dictionary.contains(endWord))
        {
            ArrayList<List<String>> empty = new ArrayList<>();
            return empty;
        }

        List<List<String>> result = new ArrayList<>();

        Hashtable<String,Integer> steps = new Hashtable<>();

        steps.put(beginWord, 1);

        Hashtable<String,List<String>> parents = new Hashtable<>();

        boolean found=false;

        Queue<String> q = new LinkedList<String>();

        q.add(beginWord);

        int step=0;

        while(!q.isEmpty() && !found )
        {
            step++;
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                String word = q.poll();
                for(int j=0;j<word.length();j++)
                {
                    char[] chs = word.toCharArray();

                    for(char k='a';k<='z';k++)
                    {
                        if(chs[j]==k)
                            continue;

                        chs[j]=k;
                        String s = new String(chs);

                        if(!dictionary.contains(s))
                            continue;


                        if(s.equals(endWord))
                        {
                            found=true;
                        }

                        if(step < steps.getOrDefault(s, Integer.MAX_VALUE)){

                            if(parents.containsKey(s))
                            {
                                parents.get(s).add(word);
                            }
                            else
                            {
                                ArrayList<String> tmp = new ArrayList<>();
                                tmp.add(word);
                                parents.put(s, tmp);
                            }
                        }

                        dictionary.remove(s);

                        q.add(s);

                        steps.put(s, step+1);
                    }
                }
            }
        }

        if(found)
        {
            ArrayList<String> curr=new ArrayList<String>();
            curr.add(endWord);
            getPaths(beginWord,endWord,parents,curr,result);
        }

        return result;
    }


    public static void getPaths(String beginWord,String word,Map<String,List<String>> parents,List<String> curr,List<List<String>> result)
    {
        if(word.equals(beginWord))
        {
            result.add(new ArrayList<String>(curr));
            return;
        }

        for(String parent : parents.get(word))
        {
            curr.add(parent);
            getPaths(beginWord,parent,parents,curr,result);
            curr.remove(parent);
        }
    }
}
