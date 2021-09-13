package BinarySearchTree;

import java.util.Objects;

public class Node {
    Node parent;
    Node left;
    Node right;
    String data;

    public Node() {
    }

    public Node(String data) {
        this.data = data;
    }

    public int height() {
        int leftHeight = -1;
        int rightHeight = -1;

        if (left == null & right == null) {
            return 0;
        }

        if (left != null) {
            leftHeight = left.height();
        }

        if (right != null) {
            rightHeight = right.height();
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int balance() {

        if (left == null && right == null) {
            // no children

            return 0;
        }

        else if (left == null) {
            return -1 - right.height();
        }

        else if (right == null) {
            return left.height() - -1;
        }

        return left.height() - right.height();
    }
}