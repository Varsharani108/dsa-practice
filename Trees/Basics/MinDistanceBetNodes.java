
package Trees.Basics;

public class MinDistanceBetNodes {

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

    // Find Lowest Common Ancestor
    public static Node lca(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }

    // Find distance from root to a target node
    public static int distance(Node root, int n, int level) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return level;
        }

        int leftDistance = distance(root.left, n, level + 1);

        if (leftDistance != -1) {
            return leftDistance;
        }

        return distance(root.right, n, level + 1);
    }

    // Minimum distance between two nodes
    public static int minDistance(Node root, int n1, int n2) {
        Node lcaNode = lca(root, n1, n2);

        if (lcaNode == null) {
            return -1;
        }

        int d1 = distance(lcaNode, n1, 0);
        int d2 = distance(lcaNode, n2, 0);

        if (d1 == -1 || d2 == -1) {
            return -1;
        }

        return d1 + d2;
    }

    public static void main(String[] args) {
        /*
                 1
                / \
               2   3
              / \   \
             4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(minDistance(root, 4, 5));
        System.out.println(minDistance(root, 4, 6));
    }
}
