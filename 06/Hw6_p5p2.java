import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Hw6_p5p2 {
    // public void addEdge(ArrayList<ArrayList<String>> adjL, String s, int d){

    // }
    class Node {
        String data;
        Node next;

        public Node(String data) {
            this.data = data;
            this.next = null;
        }

        public static Node head = null;
        public static Node tail = null;

        public static void addNode(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
    }

    // public void addNode(String data){

    // }

    public static void allfollows(String n, ArrayList<String> followers) {
        if (followers.size() == 0) {
            System.out.println(n + " directly follows no one");
        } else {
            String listString = String.join(", ", followers);
            System.out.println(n + " directly follows" + listString);
        }
    }
    // public void addFollower(String n) {

    // }

    public static void main(String[] args) {
        ArrayList<String> followingList = new ArrayList<String>();
        ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
        ArrayList<Node> listName = new ArrayList<Node>();

        try { // try opting the .txt file before anything else
            Scanner fileInput = new Scanner(new File("follows_input.txt"));
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] tempList = line.split(","); // returs a list
                // System.out.println(tempList[0]); // returns the first elelemtn in the array
                for (int i = 1; i < tempList.length; i++) { // skips over the first element

                    followingList.add(tempList[i]);
                }
                String newNode = Node.addNode(tempList[0]);
                listName.add(newNode);
                allfollows(tempList[0], followingList);
                followingList.clear();
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
