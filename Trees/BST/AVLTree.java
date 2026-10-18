
package Trees.BST;

public class AVLTree {

    static class Node {
        int data;
        Node left;
        Node right;
        int height;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    // Node ki height return karega
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // Balance factor = left height - right height
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    // Right rotation
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        // Heights update karo
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Left rotation
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        // Heights update karo
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    // AVL Tree mein insertion
    public static Node insert(Node root, int key) {

        // Normal BST insertion
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root; // Duplicate values allow nahi hain
        }

        // Height update karo
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Balance factor calculate karo
        int balance = getBalance(root);

        // LL Case
        if (balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        // RR Case
        if (balance < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        // LR Case
        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RL Case
        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        System.out.print("Inorder traversal: ");
        inorder(root);

        System.out.println("\nRoot after balancing: " + root.data);
        System.out.println("Height: " + height(root));
    }
}
