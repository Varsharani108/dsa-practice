
package Trees.BST;

public class ValidateBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isBST(Node root, long min, long max) {

        // Empty tree is a valid BST
        if (root == null) {
            return true;
        }

        // Node ki value valid range mein honi chahiye
        if (root.data <= min || root.data >= max) {
            return false;
        }

        // Left subtree: values root.data se chhoti honi chahiye
        // Right subtree: values root.data se badi honi chahiye
        return isBST(root.left, min, root.data)
                && isBST(root.right, root.data, max);
    }

    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);

        root.left.left = new Node(3);
        root.left.right = new Node(9); // Invalid: 9, 8 se bada hai

        System.out.println(isBST(root, Long.MIN_VALUE, Long.MAX_VALUE));
    }
}
