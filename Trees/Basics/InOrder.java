package Trees.Basics;

public class InOrder {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void inOrder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Left
        inOrder(root.left);

        // Root
        System.out.print(root.data + " ");

        // Right
        inOrder(root.right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        inOrder(root);
    }
}