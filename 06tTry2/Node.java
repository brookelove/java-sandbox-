import java.util.ArrayList;

public class Node {

    Character data;
    ArrayList<Character> followers;

    public Node(char data) {
        this.data = data;
        this.followers = new ArrayList<Character>();
    }

    // public void addNode(String otherEl) {
    // Node newNode = new Node(otherEl);
    // followers.add(newNode);
    // }
}
