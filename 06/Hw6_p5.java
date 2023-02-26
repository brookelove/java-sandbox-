import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Hw6_p5 {

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

        try { // try opting the .txt file before anything else
            Scanner fileInput = new Scanner(new File("follows_input.txt"));
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] tempList = line.split(","); // returs a list
                // System.out.println(tempList[0]); // returns the first elelemtn in the array
                // tempList.remove(0);
                for (int i = 1; i < tempList.length; i++) { // skips over the first element

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
        System.out.println(list);
    }
}