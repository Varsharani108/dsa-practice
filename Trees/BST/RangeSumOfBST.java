
package Trees.BST;

public class RangeSumOfBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static int rangeSumBST(Node root, int low, int high) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Root ki value range se chhoti hai
        if (root.data < low) {
            return rangeSumBST(root.right, low, high);
        }

        // Root ki value range se badi hai
        if (root.data > high) {
            return rangeSumBST(root.left, low, high);
        }

        // Root range mein hai: root + left subtree + right subtree
        return root.data
                + rangeSumBST(root.left, low, high)
                + rangeSumBST(root.right, low, high);
    }

    public static void main(String[] args) {

        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.right = new Node(18);

        int low = 7;
        int high = 15;

        System.out.println(
                "Range sum: " + rangeSumBST(root, low, high)
        );
    }
}
