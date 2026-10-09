
package Trees.Basics;

public class PostOrder {

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

    public static void postOrder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Left
        postOrder(root.left);

        // Right
        postOrder(root.right);

        // Root
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        postOrder(root);
    }
}