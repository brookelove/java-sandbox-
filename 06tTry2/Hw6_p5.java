import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Hw6_p5 {
    // public static void checkIndirect (int index, ArrayList<Character> arrList,
    // ArrayList<Node> adjList){
    // //create an integer array to store all the visited nodes
    // int[] visit = new int[adjList.size()];
    // visit = -1; //int direct connection
    // for (Characher ch:arrList){
    // if(visit[i] == 1 ){
    // nodeIndirect = nodeIndirect + adjList.get(i).data + ",";

    // }
    // }
    // public static void checkIndirect(int index, ArrayList<Character> arrList,
    // ArrayList<Node> adjList) {
    // int[] visit = new int[adjList.size()];
    // visit = -1;
    // String nodeIndirect = "";
    // }

    public static void allFollows(char X, ArrayList<Node> adjList, int index) {
        // System.out.println(adjList.indexOf(X));
        // int index = 0; // store the index from the char
        String directNodes = ""; // create a strign variable to store directy connectedd nodes
        for (Character ch : adjList.get(index).followers) { // for loop to find nodes
            directNodes = directNodes + ch + ", ";

        }
        // remove the comma on the last condiion
        // then list the directly follows node
        System.out.println(X + " directly follows {" + directNodes + "}");

    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Node> adjList = new ArrayList<Node>();
        ArrayList<Character> charList = new ArrayList<Character>();
        Scanner fileInput = new Scanner(new File("follows_input.txt"));
        int index = 0;
        while (fileInput.hasNext()) {
            String line = fileInput.nextLine();
            String[] splitLine = line.split(", ");
            charList.add(splitLine[0].charAt(0));
            adjList.add(new Node(splitLine[0].charAt(0)));
            for (int i = 0; i < splitLine.length; i++) {
                adjList.get(index).followers.add(splitLine[i].charAt(0));
            }
            index++;
        }
        // make a for loop to create a list of characters that then go through the loop

        for (int i = 0; i < charList.size(); i++) {
            allFollows(charList.get(i), adjList, i);
        }
    }
}