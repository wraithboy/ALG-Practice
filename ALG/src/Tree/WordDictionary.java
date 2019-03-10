package Tree;

public class WordDictionary {

    TrieNode root;

    class TrieNode{

        TrieNode[] children;
        boolean isEnd;

        public TrieNode()
        {
            children=new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        TrieNode curr=root;
        for(char c: word.toCharArray())
        {
            if(curr.children[c-'a']==null)
            {
                TrieNode n=new TrieNode();
                curr.children[c-'a']=n;
            }
            curr=curr.children[c-'a'];
        }

        curr.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode curr=root;

        for(int i=0;i<chars.length;i++)
        {
            if(chars[i]!='.')
            {
                if(curr.children[chars[i]-'a']==null)
                    return false;
                else
                    curr=curr.children[chars[i]-'a'];
            }
            else
            {
                boolean result=false;
                for(char j='a';j<='z';j++)
                {
                    if(curr.children[j]!=null)
                        result= result || search(j+word.substring(1));
                }

                return result;
            }
        }

        return curr.isEnd;
    }

}
