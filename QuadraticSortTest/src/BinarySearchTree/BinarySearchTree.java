package BinarySearchTree;

public class BinarySearchTree {
    public Node root;

    String ERROR_WRONG_ROTATION = "Wrong rotation side";

    // OBJECT BUILDING METHODS //

    public BinarySearchTree() {
        root = new Node();
    }

    public BinarySearchTree(String data) {
        root = new Node(data);
    }

    // GET DATA METHODS //
    public Node getRoot() {
        return root;
    }

    public Node search(String data) {
        return searchRec(data, root);
    }

    private Node searchRec(String data, Node currentNode) {
        if (currentNode == null) return null; // node not found
        if (data.equals(currentNode.data)) return currentNode; // node is found
        boolean toRight = data.compareTo(currentNode.data) > 0;

        if (toRight) {
            return searchRec(data, currentNode.right);
        } else {
            return searchRec(data, currentNode.left);
        }
    }

    public Node getMin() {
        Node currentNode = root;
        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public Node getMax() {
        Node currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }
        return currentNode;
    }

    public Node getSuccessor(Node currentNode) {
        // returns null if not found

        return getSuccessorRec(currentNode);
    }

    private Node getSuccessorRec(Node currentNode) {

        // -- data validation -- //
        if (currentNode == null) {
            return null;
        }
        // -- -- //

        if (currentNode.right != null) {
            // returns the most left child in the right node

            currentNode = currentNode.right;
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
            return currentNode;
        }

        // in case if there's no right child
        // returns the next node that is left child of its parent node

        while (currentNode.parent != null) {
            boolean isLeftChild = currentNode.parent.left == currentNode;
            if (isLeftChild) {
                return currentNode.parent;
            } else {
                currentNode = currentNode.parent;
            }
        }

        // if not found
        return null;
    }

    public Node getPredecessor(Node currentNode) {
        // returns null if not found

        return getPredecessorRec(currentNode);
    }

    private Node getPredecessorRec(Node currentNode) {

        // -- data validation -- //
        if (currentNode == null) {
            return null;
        }
        // -- -- //

        if (currentNode.left != null) {
            // returns the most right child in the left node

            currentNode = currentNode.left;
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
            return currentNode;
        }

        // in case if there's no left child
        // returns the next node that is right child of its parent node

        while (currentNode.parent != null) {
            boolean isRightChild = currentNode.parent.right == currentNode;
            if (isRightChild) {
                return currentNode.parent;
            } else {
                currentNode = currentNode.parent;
            }
        }

        // if not found
        return null;
    }

    // ACTION METHODS //
    public void insert(String data) {
        balance(insertRec(data, root));
    }

    private Node insertRec(String data, Node currentNode) {

        if (currentNode.data == null) {
            currentNode.data = data;
            return currentNode;
        }

        boolean toRight = data.compareTo(currentNode.data) > 0; // to the right side or to the left side
        boolean hasRightChild = currentNode.right != null;
        boolean hasLeftChild = currentNode.left != null;

        if (toRight) {
            // new data is bigger currentNode node's data

            if (hasRightChild) {
                return insertRec(data, currentNode.right);
            } else {
                // if has no right child

                currentNode.right = new Node(data); // create new node
                currentNode.right.parent = currentNode; // link right node to the parent
                return currentNode.right; // return new node
            }
        }

        else {
            // new data is less currentNode node's data

            if (hasLeftChild) {
                return insertRec(data, currentNode.left);
            } else {
                // if has no left child

                currentNode.left = new Node(data); // create new node
                currentNode.left.parent = currentNode; // link right node to the parent
                return currentNode.left; // return new node
            }
        }
    }

    public void delete(Node node) {
        if (node == null) {
            return;
        }

        deleteRec(node);
    }

    private Node deleteRec(Node currentNode) {
        // returns the replacement of currentNode

        if (currentNode.parent == null) {
            currentNode.parent = new Node();
            currentNode.parent.left = currentNode;
        }
        boolean isLeftChild = currentNode.parent.left == currentNode;

        if (currentNode.left == null & currentNode.right == null) {
            // NO CHILDREN - has no children

            if (isLeftChild) {
                // if currentNode is left child

                currentNode.parent.left = null;
            } else {
                // if currentNode is right child

                currentNode.parent.right = null;
            }
            if (root.left == null & root.right == null) {
                // if root is the node to be deleted

                root = null;
            }
        }

        else if (currentNode.left != null & currentNode.right == null) {
            // ONE CHILD  - only has left child

            if (isLeftChild) {
                currentNode.parent.left = currentNode.left; // linking currentNode.parent to the new child
            } else {
                // is right child
                currentNode.parent.right = currentNode.left;
            }

            currentNode.left.parent = currentNode.parent; // link the new child to currentNode.parent

            if (currentNode == root) {
                // if root is the node to be deleted
                root = currentNode.left;
            }
        }

        else if (currentNode.left == null & currentNode.right != null) {
            // ONE CHILD  - only has right child

            if (isLeftChild) {
                currentNode.parent.left = currentNode.right; // linking currentNode.parent to the new child
            } else {
                // is right child
                currentNode.parent.right = currentNode.right;
            }

            currentNode.right.parent = currentNode.parent; // link the new child to currentNode.parent

            if (currentNode == root) {
                // if root is the node to be deleted
                root = currentNode.right;
            }
        }

        else {
            // TWO CHILDREN - has two children
            Node successorNode = getSuccessor(currentNode);


            // replacing successorNode with its right child
            successorNode.parent.left = successorNode.right;
            if (successorNode.right != null) {
                successorNode.right.parent = successorNode.parent;
            }

            // attaching currentNode's right node to successorNode's right node
            successorNode.right = currentNode.right;
            currentNode.right.parent = successorNode;

            // linking successorNode with currentNode's parent and vise-versa
            successorNode.parent = currentNode.parent;
            if (isLeftChild) {
                currentNode.parent.left = successorNode;
            } else {
                currentNode.parent.right = successorNode;
            }

            // attaching currentNode's left node to successorNode's left node
            successorNode.left = currentNode.left;
            successorNode.left.parent = successorNode;

            currentNode.parent = null;
            currentNode.left = null;
            currentNode.right = null;
            currentNode.data = null;

            if (root.data == null) {
                root = successorNode;
                root.parent = null;
            }

            return successorNode;
        }

        return currentNode;
    }

    // SERVICE METHODS //
    public void rotateLeft(Node currentNode) {

        if (currentNode.right == null) {
            throw new RuntimeException(ERROR_WRONG_ROTATION);
        }

        Node parentNode = currentNode.parent;
        Node rightChild = currentNode.right;
        currentNode.right = rightChild.left;
        rightChild.left = currentNode;
        currentNode.parent = rightChild;
        rightChild.parent = parentNode;

        if (parentNode == null) {
            // if this is the root node

            updateRoot();
            return;
        }

        if (parentNode.left == currentNode) {
            // if currentNode node is the left child

            parentNode.left = rightChild;
        } else {
            // if it's the right child
            parentNode.right = rightChild;
        }
        updateRoot();
    }

    public void rotateRight(Node currentNode) {

        if (currentNode.left == null) {
            throw new RuntimeException(ERROR_WRONG_ROTATION);
        }

        Node parentNode = currentNode.parent;
        Node leftChild = currentNode.left;
        currentNode.left = leftChild.right;
        leftChild.right = currentNode;
        currentNode.parent = leftChild;
        leftChild.parent = parentNode;


        if (parentNode == null) {
            // is root node

            updateRoot();
            return;
        }

        if (parentNode.left == currentNode) {
            // is left child

            parentNode.left = leftChild;
        } else {
            // is right child

            parentNode.right = leftChild;
        }

        updateRoot();
    }

    public void balance(Node currentNode) {
        if (currentNode == null) {
            return;
        }

        if (currentNode.balance() > 1) {
            // left unbalanced

            if (currentNode.left.balance() > 0) {
                // left-left case

                rotateRight(currentNode);
            } else {
                // left-right case

                rotateLeft(currentNode.left);
                rotateRight(currentNode);
            }
        }

        else if (currentNode.balance() < -1) {

            if (currentNode.right.balance() < 0) {
                rotateLeft(currentNode);
            } else {
                rotateRight(currentNode.right);
                rotateLeft(currentNode);
            }
        }
        balance(currentNode.parent);
    }

    private void updateRoot() {
        Node min = getMin();
        while (min.parent != null) {
            min = min.parent;
        }
        root = min;
    }
}