package Trees.BST;

public class PrintInRange {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Print values within a given range
    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }

        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.print(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (root.data < X) {
            printInRange(root.right, X, Y);
        } else {
            printInRange(root.left, X, Y);
        }
    }

    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        int X = 5;
        int Y = 11;

        printInRange(root, X, Y);
    }
}
