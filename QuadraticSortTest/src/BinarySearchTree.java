public class BinarySearchTree {
    package BinarySearchTree;
import java.util.Objects;
    public class BinarySearchTree {
        public Node root;
        public static final String not_found = "The item is not found";
        // user
        public BinarySearchTree() {
            root = new Node();
        }
        // user
        public BinarySearchTree(String key) {
            root = new Node(key);
        }

        //user
        // user
        public void insert(String key) {
            if (root.key == null) {
                root = new Node(key);
                return;
            }
            balance(Objects.requireNonNull(insertRec(key, root)).parentNode);
        }
        private static Node insertRec(String key, Node focusNode) {
            if (key.compareTo(focusNode.key) > 0) {
                // if the node is to be placed on the right
                // (if new key is greater than the focusNode key)
                if (focusNode.rightNode == null) {
                    focusNode.rightNode = new Node(key);
                    focusNode.rightNode.parentNode = focusNode;
                    return focusNode.rightNode;
                } else {
                    // if the right child does exist
                    return insertRec(key, focusNode.rightNode);
                }
            }
            else if (key.compareTo(focusNode.key) <= 0) {
                // if the node is to be placed on the left
                // (if new key is lesser than the focusNode key)
                if (focusNode.leftNode == null) {
                    focusNode.leftNode = new Node(key);
                    focusNode.leftNode.parentNode = focusNode;
                    return focusNode.leftNode;
                } else {
                    // if the left child does exist
                    return insertRec(key, focusNode.leftNode);
                }
            }
            return null;
        }
        public void delete(Node focusNode) {
            Node newHeadNode = deleteRec(focusNode);

//        System.out.println("newhead: " + newHeadNode.getKey());
//        System.out.println("left node: " + newHeadNode.leftNode.getKey());
//        System.out.println("left node parent: " + newHeadNode.leftNode.parentNode.getKey());
//        System.out.println("right node: " + newHeadNode.rightNode);

            if (newHeadNode != null) {
                balance(newHeadNode);
            }
        }
        // user
        private Node deleteRec(Node focusNode) {
            // returns new head node of a tree
            if (focusNode == null) {
                return null;
            }
            Node focusNodeParent = focusNode.parentNode;
            boolean isLeftChild = false;
            if (nodeExists(focusNodeParent, "left")) {
                isLeftChild = focusNode == focusNodeParent.leftNode;
            }
            if (countChildren(focusNode) == 2) {
                Node focusNodeSuccessor = getSuccessor(focusNode);
                focusNodeSuccessor.leftNode = focusNode.leftNode;
                if (isLeftChild) {
                    focusNodeParent.leftNode = focusNodeSuccessor;
                    focusNodeSuccessor.leftNode.parentNode = focusNodeSuccessor;
                } else {
                    focusNodeParent.rightNode = focusNodeSuccessor;
                    focusNodeSuccessor.rightNode.parentNode = focusNodeSuccessor;
                }
                focusNodeSuccessor.parentNode = focusNodeParent;
                return focusNodeSuccessor;
            }
            else if (countChildren(focusNode) == 1) {
                if (nodeExists(focusNode, "left")) {
                    // if the node only has left child
                    Node newChild = focusNode.leftNode; // copy new child
                    focusNode.leftNode.parentNode = null; // delete focusNode from memory
                    if (isLeftChild) {
                        focusNodeParent.leftNode = newChild; // link parent to child
                        newChild.parentNode = focusNodeParent; // link child to parent
                        return focusNodeParent.leftNode;
                    } else {
                        focusNodeParent.rightNode = newChild;
                        newChild.parentNode = focusNodeParent; // link child to parent
                        return focusNodeParent.rightNode;
                    }
                } else {
                    // if the node only has right child
                    Node newChild = focusNode.rightNode;
                    focusNode.rightNode.parentNode = null;
                    if (isLeftChild) {
                        focusNodeParent.leftNode = newChild;
                        newChild.parentNode = focusNodeParent;
                        return focusNodeParent.leftNode;
                    } else {
                        focusNodeParent.rightNode = newChild;
                        newChild.parentNode = focusNodeParent;
                        return focusNodeParent.rightNode;
                    }
                }
            }
            else if (countChildren(focusNode) == 0) {
                if (isLeftChild) {
                    focusNodeParent.leftNode = null;
                    return focusNodeParent;
                } else {
                    focusNodeParent.rightNode = null;
                    return focusNodeParent;
                }
            }
            return null;
        }
        private Node rotateRight(Node focusNode) {
            Node parentNode = focusNode.parentNode;
            Node leftChild = focusNode.leftNode;
            focusNode.leftNode = leftChild.rightNode;
            if (leftChild.rightNode != null) {
                leftChild.rightNode.parentNode = leftChild;
            }
            leftChild.rightNode = focusNode;
            focusNode.parentNode = leftChild;
            leftChild.parentNode = parentNode;
            if (parentNode != null) {
                if (parentNode.leftNode == focusNode) {
                    parentNode.leftNode = leftChild;
                } else {
                    parentNode.rightNode = leftChild;
                }
            }
            root = getHighest();
            return leftChild;
        }
        private Node rotateLeft(Node focusNode) {
            Node parentNode = focusNode.parentNode;
            Node rightChild = focusNode.rightNode;
            focusNode.rightNode = rightChild.leftNode;
            if (rightChild.rightNode != null) {
                rightChild.rightNode.parentNode = rightChild;
            }
            rightChild.leftNode = focusNode;
            focusNode.parentNode = rightChild;
            rightChild.parentNode = parentNode;
            if (parentNode != null) {
                if (parentNode.leftNode == focusNode) {
                    parentNode.leftNode = rightChild;
                } else {
                    parentNode.rightNode = rightChild;
                }
            }
            root = getHighest();
            return rightChild;
        }

        private void rotateLeftRight(Node focusNode) {
            focusNode.leftNode = rotateLeft(focusNode.leftNode);
            focusNode = rotateRight(focusNode);
        }

        private void rotateRightLeft(Node focusNode) {
            focusNode.rightNode = rotateRight(focusNode.rightNode);
            focusNode = rotateLeft(focusNode);
        }

        // tests
        public void balance(Node focusNode) {
            while (focusNode != null) {
                if (focusNode.getBalance() > 1) {
                    // if left-heavy
                    if (focusNode.leftNode.getBalance() > 0) {
                        // left-left case
                        focusNode = rotateRight(focusNode);
                    } else {
                        // left-right case

                        rotateLeftRight(focusNode);
                        focusNode.leftNode = rotateLeft(focusNode.leftNode);
                        focusNode = rotateRight(focusNode);
                    }
                }

                else if (focusNode.getBalance() < -1) {
                    // if right-heavy
                    if (focusNode.rightNode.getBalance() < 0) {
                        // right-right case

                        focusNode = rotateRight(focusNode);
                        focusNode = rotateLeft(focusNode);
                    } else {
                        // right-left case

                        rotateRightLeft(focusNode);
                        focusNode.rightNode = rotateRight(focusNode.rightNode);
                        focusNode = rotateLeft(focusNode);
                    }
                }

                focusNode = focusNode.parentNode;
            }
        }
        // user
        public Node search(String key) {
            return searchRec(key, root);
        }
        private static Node searchRec(String key, Node focusNode) {
            if (focusNode == null) {
                // if last node and not found
                return null;
            }
            if (key.equals(focusNode.key)) {
                // if node is found
                return focusNode;
            }
            // if node is not found
            if (key.compareTo(focusNode.key) > 0) {
                return searchRec(key, focusNode.rightNode);
            }
            else if (key.compareTo(focusNode.key) < 0) {
                return searchRec(key, focusNode.leftNode);
            }
            return null;
        }
        // user
        public Node getMin() {
            Node focusNode = root;
            while (nodeExists(focusNode, "left")) {
                focusNode = focusNode.leftNode;
            }
            return focusNode;
        }
        // user
        public Node getMax() {
            Node focusNode = root;
            while (nodeExists(focusNode, "right")) {
                focusNode = focusNode.rightNode;
            }
            return focusNode;
        }
        // tests
        public Node getSuccessor(Node focusNode) {
            return getSuccessorRec(focusNode);
        }
        private static Node getSuccessorRec(Node focusNode) {
            if (nodeExists(focusNode, "right")) {
                focusNode = focusNode.rightNode;
                while (focusNode.leftNode != null) {
                    focusNode = focusNode.leftNode;
                }
                return focusNode;
            } else {
                // if the right node doesn't exist
                while (nodeExists(focusNode, "parent")) {
                    Node focusNodeParent = focusNode.parentNode;
                    if (focusNodeParent.leftNode == focusNode) {
                        // if parent element has a left child
                        // and this left child is the focus node
                        return focusNodeParent;
                    } else {
                        focusNode = focusNodeParent;
                    }
                }
                return null;
            }
        }
        // tests
        public Node getPredecessor(Node focusNode) {
            return getPredecessorRec(focusNode);
        }
        private static Node getPredecessorRec(Node focusNode) {
            if (nodeExists(focusNode, "left")) {
                focusNode = focusNode.leftNode;
                while (nodeExists(focusNode, "right")) {
                    focusNode = focusNode.rightNode;
                }
                return focusNode;
            } else {
                // if left node doesn't exist
                while (nodeExists(focusNode, "parent")) {
                    Node focusNodeParent = focusNode.parentNode;
                    if (focusNodeParent.rightNode == focusNode) {
                        // if parent element has a right child
                        // and this left child is the focus node
                        return focusNodeParent;
                    } else {
                        // if right node isn't the focus node
                        focusNode = focusNodeParent;
                    }
                }
                return null;
            }
        }
        private static boolean nodeExists(Node focusNode, String whatNode) {
            boolean doesExist;
            switch (whatNode) {
                case "right" -> {
                    try {
                        // if rightNode exists, returns true
                        doesExist = focusNode.rightNode != null;
                    } catch (Exception NullPointerException) {
                        doesExist = false;
                    }
                    return doesExist;
                }
                case "left" -> {
                    try {
                        // if leftNode exists, returns true
                        doesExist = focusNode.leftNode != null;
                    } catch (Exception NullPointerException) {
                        doesExist = false;
                    }
                    return doesExist;
                }
                case "parent" -> {
                    try {
                        // if parentNode exists, returns true
                        doesExist = focusNode.parentNode != null;
                    } catch (Exception NullPointerException) {
                        doesExist = false;
                    }
                    return doesExist;
                }
                default -> throw new RuntimeException("wrong node name");
            }
        }
        private static int countChildren(Node focusNode) {
            int count = 0;
            if (nodeExists(focusNode, "left")) {
                count++;
            }
            if (nodeExists(focusNode, "right")) {
                count++;
            }
            return count;
        }
        private Node getHighest() {
            Node firstNode = getMin();
            while (firstNode.parentNode != null) {
                firstNode = firstNode.parentNode;
            }
            return firstNode;
        }
        // dev
        public void printAll(boolean reversed) {
            // reversed - from min to max
            // normal - max to min
            reversed = !reversed;
            if (reversed) {
                printAllRec(getMax(), reversed);
            } else {
                printAllRec(getMin(), reversed);
            }
        }
        private static void printAllRec(Node focusNode, boolean reversed){
            if (focusNode == null) {
                return;
            }
            System.out.println(focusNode.key);
            Node nextNode;
            if (reversed) {
                nextNode = getPredecessorRec(focusNode);
            } else {
                nextNode = getSuccessorRec(focusNode);
            }
            printAllRec(nextNode, reversed);
        }
    }
}
