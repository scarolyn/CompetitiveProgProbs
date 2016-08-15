import java.util.*;
public class LevelTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        System.out.println(levelOrderTraversal == "1 2 3 4 5 6");
    }
    
    public static String levelOrderTraversal(Node root) {
        Queue<Node> toProcess = new LinkedList<>();
        StringBuilder traversal = new StringBuilder();
        toProcess.add(root);
        while (toProcess.peek() != null) {
            traversal.append(toProcess.poll() + " ");
            toProcess.add(toProcess.left);
            toProcess.add(toProcess.right);
        }
        return traversal.toString();
    }

    private class Node() {
        Node left;
        Node right;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }
}