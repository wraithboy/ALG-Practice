package Tree;

import java.util.ArrayList;
import java.util.List;

public class Trie {

    TrieNode root;

    class TrieNode
    {
        TrieNode[] children;
        boolean isWord;

        public TrieNode()
        {
            children=new TrieNode[26];
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {

        char[] chars=word.toCharArray();
        TrieNode curr=root;
        for(int i=0;i<chars.length;i++)
        {
            if(curr.children[chars[i]-'a']==null)
            {
                TrieNode n = new TrieNode();
            }

            curr=curr.children[chars[i-'a']];
        }

        curr.isWord=true;

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {

        char[] chars = word.toCharArray();

        TrieNode curr=root;

        for(int i=0;i<word.length();i++)
        {
            if(curr.children[chars[i]-'a']==null)
            {
                return false;
            }
            else
            {
                curr=curr.children[chars[i]-'a'];
            }
        }

        return curr.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        char[] chars = prefix.toCharArray();

        TrieNode curr=root;

        for(int i=0;i<prefix.length();i++)
        {
            if(curr.children[chars[i]-'a']==null)
            {
                return false;
            }
            else
            {
                curr=curr.children[chars[i]-'a'];
            }
        }

        return true;

    }
}
