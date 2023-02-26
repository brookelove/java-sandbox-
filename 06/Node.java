import java.util.ArrayList;

public class Node {

    String data;
    ArrayList<Node> followers;

    public Node(String data) {
        this.data = data;
        this.followers = null;
    }

    public void addNode(String data) {
        Node newNode = new Node(data);
        followers.add(newNode);
    }
}
