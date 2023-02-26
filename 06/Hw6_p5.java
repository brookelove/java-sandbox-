import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Hw6_p5 {
    // public void addEdge(ArrayList<ArrayList<String>> adjL, String s, int d){

    // }
    // class Node {
    // String data;
    // Node next;

    // public Node(String data) {
    // this.data = data;
    // this.next = null;
    // }
    // }

    // public Node head = null;
    // public Node tail = null;

    // public void addNode(String data) {
    // Node newNode = new Node(data);
    // if (head == null) {
    // head = newNode;
    // tail = newNode;
    // } else {
    // tail.next = newNode;
    // tail = newNode;
    // }
    // }
    // static ArrayList<String> followingList = new ArrayList<String>();
    static ArrayList<String> longList = new ArrayList<String>();

    public static void checkArr(String follower) {
        // System.out.println();

        for (int i = 0; i < longList.size(); i++) {
            // System.out.println(longList.get(i) + "\n");
            // System.out.print(longList.indexOf(follower));
            // if (longList.contains(follower)){
            // String split = longList.get(i);
            // System.out.println(split);

        }
        // }
        // }
        // for (int i = 0; i < longList.size(); i++) {
        if (longList.contains(follower)) {
            System.out.print(longList.indexOf(follower));
        }

    }

    public static void allfollows(String n, ArrayList<String> followers) {
        if (followers.size() == 0) {
            System.out.println(n + " directly follows no one");
        } else {
            String listString = String.join(", ", followers);
            System.out.println(n + " directly follows " + listString);
        }
        // System.out.println(longList.size());
        // for (int i = 0; i < longList.size(); i++) {
        // System.out.println(longList.get(i));

        // }
        int i = 0;
        while (i != followers.size()) {
            checkArr(followers.get(i));
            i++;
        }

    }
    // public void addFollower(String n) {

    // }

    public static void main(String[] args) {
        ArrayList<String> followingList = new ArrayList<String>();
        // ArrayList<Node> everyNode = newArrayList<Node> ();
        // ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        try { // try opting the .txt file before anything else
            Scanner fileInput = new Scanner(new File("follows_input.txt"));
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] tempList = line.split(", "); // returs a list
                // System.out.println(tempList[0]); // returns the first elelemtn in the array
                longList.add(line);
                for (int i = 1; i < tempList.length; i++) { // skips over the first element
                    // everyNode.add(tempList[0]);
                    followingList.add(tempList[i]);
                }
                // System.out.println(followingList);
                // System.out.println(followingList);
                allfollows(tempList[0], followingList);
                followingList.clear();
                // take out the first item in the array
                // for loop
            }
            fileInput.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // for (int i = 0; i < listSize.size(); i++) {
        // System.out.println(listSize.get(i));

        // }
        // System.out.println(list);
    }
}