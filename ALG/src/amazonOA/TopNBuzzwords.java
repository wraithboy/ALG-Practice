package amazonOA;

import java.util.*;

public class TopNBuzzwords {

    public static void main(String[] args) {

            int numToys = 6;
            int topToys = 2;
            String[] toys = {"elmo", "elsa", "legos", "drone", "tablet", "warcraft"};
            int numQuotes = 6;
            String[] quotes = {
                    "Elmo is the hottest of the season, Elsa! Elmo will be on every kid's wishlist!",
                    "The new Elmo dolls are super high quality",
                    "Expect the Elsa dolls to be very popular this year, Elsa!",
                    "Elsa and Elmo are the toys I'll be buying for my kids, Elsa is good",
                    "For parents of older kids, look into buying them a drone",
                    "Warcraft is slowly rising in popularity ahead of Elmo the holiday season"
            };

            System.out.println(topNBuzzwords(numToys, topToys, toys, numQuotes, quotes));
        }

        private static List<String> topNBuzzwords(int numToys, int topToys, String[] toys, int numQuotes, String[] quotes) {

            HashMap<String, WordCount> toyMap = new HashMap<>();

            for(String toy : toys){
                toyMap.put(toy, new WordCount());
            }

            for(int i=0;i<quotes.length;i++){
                String quote = quotes[i];
                String[] words = quote.split("\\W+");
                for(String word : words){
                    word=word.toLowerCase();
                    if(toyMap.containsKey(word)){
                        WordCount wordCount = toyMap.get(word);
                        wordCount.count++;
                        wordCount.quoteIds.add(String.valueOf(i));
                        toyMap.put(word,wordCount);
                    }
                }
            }

            PriorityQueue<Map.Entry<String,WordCount>> heap = new PriorityQueue<>((a,b)-> a.getValue().count==b.getValue().count? a.getValue().quoteIds.size()==b.getValue().quoteIds.size()?a.getKey().compareTo(b.getKey()):a.getValue().quoteIds.size()-b.getValue().quoteIds.size():a.getValue().count-b.getValue().count);

            for(Map.Entry<String,WordCount> entry : toyMap.entrySet())
            {
                heap.add(entry);
                if(heap.size()>topToys)
                    heap.poll();
            }
            System.out.println(heap);
            LinkedList<String> list = new LinkedList<>();

            while(!heap.isEmpty())
            {
                list.addFirst(heap.poll().getKey());
            }
            return list;
        }
    }

    class WordCount
    {
        int count;
        Set<String> quoteIds;

        public WordCount()
        {
            this.count=0;
            this.quoteIds=new HashSet<>();
        }

        @Override
        public String toString() {
            return "WordCount{" +
                    "count=" + count +
                    ", quoteIds=" + quoteIds +
                    '}';
        }
    }
