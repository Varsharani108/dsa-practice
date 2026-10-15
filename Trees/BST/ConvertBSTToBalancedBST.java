
package Trees.BST;

import java.util.ArrayList;

public class ConvertBSTToBalancedBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Inorder traversal: BST ki values sorted order mein milengi
    public static void getInorder(Node root, ArrayList<Integer> values) {
        if (root == null) {
            return;
        }

        getInorder(root.left, values);
        values.add(root.data);
        getInorder(root.right, values);
    }

    // Sorted values se balanced BST banao
    public static Node createBalancedBST(
            ArrayList<Integer> values, int start, int end) {

        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        Node root = new Node(values.get(mid));

        root.left = createBalancedBST(values, start, mid - 1);
        root.right = createBalancedBST(values, mid + 1, end);

        return root;
    }

    public static Node balanceBST(Node root) {
        ArrayList<Integer> values = new ArrayList<>();

        getInorder(root, values);

        return createBalancedBST(values, 0, values.size() - 1);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        // Unbalanced BST
        Node root = new Node(8);
        root.right = new Node(10);
        root.right.right = new Node(12);
        root.right.right.right = new Node(14);

        System.out.print("Original BST preorder: ");
        preorder(root);

        root = balanceBST(root);

        System.out.print("\nBalanced BST preorder: ");
        preorder(root);
    }
}
