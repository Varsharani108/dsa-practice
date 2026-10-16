
package Trees.BST;

import java.util.ArrayList;
import java.util.Collections;

public class MergeTwoBSTs {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static void getInorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        getInorder(root.left, list);
        list.add(root.data);
        getInorder(root.right, list);
    }

    public static ArrayList<Integer> mergeBSTs(Node root1, Node root2) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        // Dono BSTs ka inorder nikalo
        getInorder(root1, list1);
        getInorder(root2, list2);

        // Dono sorted lists merge karo
        ArrayList<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        // List1 ke remaining elements
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        // List2 ke remaining elements
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }

    public static void main(String[] args) {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        ArrayList<Integer> result = mergeBSTs(root1, root2);

        System.out.println("Merged sorted list: " + result);
    }
}
