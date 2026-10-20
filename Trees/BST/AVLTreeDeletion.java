
package Trees.BST;

public class AVLTreeDeletion {

    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1;
        }
    }

    static int height(Node root) {
        return root == null ? 0 : root.height;
    }

    static int getBalance(Node root) {
        return root == null ? 0
                : height(root.left) - height(root.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else if (key > root.data) {
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        if (balance > 1 && key < root.left.data) {
            return rightRotate(root);
        }

        if (balance < -1 && key > root.right.data) {
            return leftRotate(root);
        }

        if (balance > 1 && key > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (balance < -1 && key < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Minimum value wala node find karo
    static Node getMinValueNode(Node root) {
        Node current = root;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // AVL Tree se node delete karo
    static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }

        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {

            // Zero ya one child
            if (root.left == null || root.right == null) {
                Node child = (root.left != null)
                        ? root.left : root.right;

                if (child == null) {
                    root = null;
                } else {
                    root = child;
                }
            } else {
                // Two children: inorder successor
                Node successor = getMinValueNode(root.right);
                root.data = successor.data;
                root.right = deleteNode(root.right, successor.data);
            }
        }

        if (root == null) {
            return null;
        }

        // Height update karo
        root.height = 1 + Math.max(height(root.left), height(root.right));

        int balance = getBalance(root);

        // LL Case
        if (balance > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }

        // LR Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR Case
        if (balance < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }

        // RL Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    static void inorder(Node root) {
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

        System.out.print("Before deletion: ");
        inorder(root);

        root = deleteNode(root, 40);

        System.out.print("\nAfter deleting 40: ");
        inorder(root);

        System.out.println("\nRoot: " + root.data);
    }
}
