import java.io.File;
import java.util.Scanner;

import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class Hw6_p5 {
    static ArrayList<String> longList = new ArrayList<String>();

    public static void checkArr(String follower) {

        for (int i = 0; i < longList.size(); i++) {
            String split = longList.get(i);
            System.out.println(split);

        }
        if (longList.contains(follower)) {
            System.out.print(longList.indexOf(follower));
        }

    }

    public static void indirectNodes(ArrayList<Node> arr) {
        for (int i = 0; i < arr.size(); i++) {
            Node el = arr.get(i).followers;
            for (int j = 1; j < arr.size(); j++) {
                Node el2 = arr.get(j).followers;
                indirectNodes(el2);
            }

        }
    }

    public static void allfollows(Node n) {
        if (n.followers.isEmpty()) {
            System.out.println(n + " directly follows no one");
        } else {
            for (int i = 0; i < n.followers.size(); i++) {
                System.out.println(n + " directly follows" + n.followers.get(i));
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<String> followingList = new ArrayList<String>();
      ArrayList<Node> everyNode = newArrayList<Node>();
        //ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();

        try { // try opting the .txt file before anything else
            Scanner fileInput = new Scanner(new File("follows_input.txt"));
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] tempList = line.split(", "); // returs a list
                // System.out.println(tempList[0]); // returns the first elelemtn in the array
              	Node newNode = new Node(tempList[0]);
              	//everyNode.add(tempList
                //longList.add(line);
                for (int i = 1; i < tempList.length; i++) { // skips over the first element
										//everyNode.add(tempList[0]);
                  	Node otherEl = new Node(tempList[i]);
                    newNode.addNode(otherEl);
                }
              	everyNode.add(newNode);;
              	allfollows(newNode);
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