
package Trees.Basics;

public class SubtreeOfAnotherTree {

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

    // Check whether both trees are identical
    public static boolean isIdentical(Node root, Node subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data != subRoot.data) {
            return false;
        }

        return isIdentical(root.left, subRoot.left)
                && isIdentical(root.right, subRoot.right);
    }

    // Check whether subRoot is a subtree of root
    public static boolean isSubtree(Node root, Node subRoot) {
        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        /*
                 Main Tree
                     1
                    / \
                   2   3
                  / \  /
                 4  5 6

                 Subtree
                   2
                  / \
                 4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println(isSubtree(root, subRoot));
    }
}
