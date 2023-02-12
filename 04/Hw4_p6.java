import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

class Hw4_p6 {
    public static void createKeys(int[] arr, int upper) {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(upper);
            arr[i] = randomNum;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        // insttiate three empty areas: hash map, array list, and linked list
        HashMap<String, Integer> myMap = new HashMap<>();
        ArrayList<Integer> myArrayList = new ArrayList<>();
        LinkedList<Integer> myLinkedList = new LinkedList<>();
        int[] insertKeys = new int[10];
        // calculate average total insertion times and average total search time for
        // each data structure
        // for (int i = 0; i < 10; i++) {
        // // 1. generate 100,000 distinct random integeers from 1 to 1,000,000]
        // Random random = new Random();
        // int randomNum = random.nextInt(1000000);
        // // 2. store them in an array of integers
        // insertKeys[i] = randomNum;
        // }
        createKeys(insertKeys, 1000000);

    }

}