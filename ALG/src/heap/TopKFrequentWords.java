package heap;

import java.util.*;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();

        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int diff=count.get(o1)-count.get(o2);
                if(diff==0)
                {
                    diff=o2.compareTo(o1);
                }
                return diff;
            }
        });

        for (String word : words) {

            heap.offer(word);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return new ArrayList<String>(heap);
    }

}
