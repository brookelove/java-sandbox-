import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/*
 * Description: Even though there are nanosecond differences between the HashMap, Array List and Linked list. It seems after executing this code many times that the Array List takes the least amount of time while the Linked list takes the most amount of time to insert. Although for searching a list a HashMap can significantly search faster than either where the LinkedList has the worst time to search on the list. A hashMap takes the second to least amount of time to insert between the three, but it overall the fastest at searching a list
 */
class Hw4_p6 {
    public static void createKeys(int[] arr, int upper) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(upper);
            arr[i] = randomNum;
        }
        // System.out.println(Arrays.toString(arr));
    }

    public static void elapsedTimeOutput(int[] arr) {

    }

    public static void main(String[] args) {
        // insttiate three empty areas: hash map, array list, and linked list
        HashMap<Integer, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        long startTime, endTime, elapsedTime;
        int[] insertKeys = new int[10];
        // calculate average total insertion times and average total search time for
        createKeys(insertKeys, 1000000);
        // each data structure
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myMap.put(insertKeys[i], i);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Number of keys = 100000");
        System.out.println();
        System.out.println("HashMap average total inset time = " + elapsedTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myArrayList.add(insertKeys[i]);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList average total insert time = " + elapsedTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myLinkedList.add(insertKeys[i]);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList average total insert time = " + elapsedTime);
        System.out.println();
        // =============================================================================
        createKeys(insertKeys, 2000000);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myMap.containsKey(insertKeys[i]);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("HashMap average total search time = " + elapsedTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myArrayList.contains(insertKeys[i]);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("ArrayList average total search time = " + elapsedTime);
        startTime = System.nanoTime();
        for (int i = 0; i < 10; i++) {
            myLinkedList.contains(insertKeys[i]);
        }
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("LinkedList average total search time = " + elapsedTime);
    }

}