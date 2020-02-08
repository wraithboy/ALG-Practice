package amazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ProductSuggestions {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        Arrays.sort(products);

        TrieNode root = new TrieNode();

        for(String product : products)
        {
            TrieNode n = root;
            for(char c : product.toCharArray())
            {
                if(n.children[c-'a']==null)
                {
                    n.children[c-'a']=new TrieNode();
                }

                n=n.children[c-'a'];

                if(n.words.size()<3)
                    n.words.add(product);
            }

        }

        List<List<String>> result = new ArrayList<>();

        TrieNode n = root;

        for(int i=0;i<searchWord.length();i++)
        {
            n=n.children[searchWord.charAt(i)-'a'];

            if(n==null)
            {
                for(int j=i;j<searchWord.length();j++)
                    result.add(Collections.EMPTY_LIST);
                break;
            }

            result.add(n.words);
        }

        return result;
    }

}



class TrieNode
{
    TrieNode[] children;
    List<String> words;

    public TrieNode()
    {
        children=new TrieNode[26];
        words = new ArrayList<>();
    }
}