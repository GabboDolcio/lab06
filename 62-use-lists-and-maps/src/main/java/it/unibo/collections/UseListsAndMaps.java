package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.*;

import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private static final int ELEMS = 100_000;

    private UseListsAndMaps() {
    }

    /**
     * Program entry point.
     */
    public static void main() {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> array_l = new ArrayList<>();
        for(int i = 1000; i<2000 ; i++){
            array_l.add(i);
        }

        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> linkedList = new LinkedList<>(array_l);
        //final List<Integer> linkedList = new LinkedList<>();
        //linkedList.addAll(array_l);

        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = array_l.getFirst();
        array_l.set(0, array_l.getLast());
        array_l.set(array_l.size()-1,temp);
        
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer el : array_l) {
            IO.print(el + "; ");
        }
    

        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
       
        for (int i = 1; i <= ELEMS; i++) {
            array_l.addFirst(i);
        }
        
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Inserting " + (array_l.size() - 1000 ) + " in a ArrayLIst took " + time + "ns ("+ millis + "ms)");

        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            linkedList.addFirst(i);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Inserting " + (linkedList.size() - 1000 ) + " in a LinkedList took " + time + "ns ("+ millis + "ms)");

        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
       
        for (int i = 1; i <= 1000; i++) {
            array_l.get(array_l.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Reading " + (array_l.size() - 1000 ) + " the middle element in a ArrayLIst of Integer took " + time + "ns ("+ millis + "ms)");

        time = System.nanoTime();
        for (int i = 1; i <= ELEMS; i++) {
            linkedList.get(linkedList.size()/2);
        }
        
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        IO.println("Reading " + (linkedList.size() - 1000 ) + " the middle element in a LinkedList of Integer took " + time + "ns ("+ millis + "ms)");
        

        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> population_map = new HashMap<>();

        population_map.put("Africa", 1_110_635_000L);
        population_map.put("Americas", 972_005_000L);
        population_map.put("Antartica",0L);
        population_map.put("Asia", 4_298_723_000L);
        population_map.put("Europe", 742_452_000L);
        population_map.put("Oceania", 38_304_000L);

        IO.println(population_map);

        /*
         * 8) Compute the population of the world
         */

        long world_population = 0;

        for (String k : population_map.keySet()) {
            world_population += population_map.get(k);
        }

        IO.println("Popolazione mondiale: " + world_population);
    }
}
