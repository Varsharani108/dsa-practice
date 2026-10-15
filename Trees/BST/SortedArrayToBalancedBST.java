
package Trees.BST;

public class SortedArrayToBalancedBST {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node createBST(int arr[], int start, int end) {

        // Base case
        if (start > end) {
            return null;
        }

        // Middle element ko root banao
        int mid = start + (end - start) / 2;
        Node root = new Node(arr[mid]);

        // Left half se left subtree banao
        root.left = createBST(arr, start, mid - 1);

        // Right half se right subtree banao
        root.right = createBST(arr, mid + 1, end);

        return root;
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

        int arr[] = {3, 5, 6, 8, 10, 11, 12};

        Node root = createBST(arr, 0, arr.length - 1);

        System.out.print("Preorder of Balanced BST: ");
        preorder(root);
    }
}
