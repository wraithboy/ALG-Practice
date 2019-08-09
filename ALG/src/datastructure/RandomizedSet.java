package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer,Integer> map;
    Random rand;
    ArrayList<Integer> list;

    /** Initialize your data structure here. */
    public RandomizedSet() {
         map= new HashMap<>();
         list=new ArrayList<>();
         rand=new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(map.containsKey(val))
            return false;

        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {

        if(!map.containsKey(val))
            return false;

        int pos=map.get(val);

        if(pos<list.size()-1)
        {
            int lastone=list.get(list.size()-1);
            list.set(pos,lastone);
            map.put(lastone,pos);
        }

        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
