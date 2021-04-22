public class Main{
public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert("abcdefgh");
        tree.insert("abc");
        tree.insert("abcd");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghi");
        tree.insert("abcdef");
        tree.insert("abcdefg");
        // tree.insert("abcd");
        // tree.insert("abcde");
        // tree.insert("abc");
        tree.insert("ab");
        tree.insert("abcdefghijklmnopqrst");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcde");
        tree.insert("a");


        System.out.println(TreePrinter.getTreeDisplay(tree.root));
        tree.delete(tree.search("ab"));
        tree.delete(tree.search("a"));
        System.out.println("deleted");
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefghijklmnopqr");
        System.out.println(TreePrinter.getTreeDisplay(tree.root));
        System.out.println(tree.search("abcdefg").getBalance());
        }
        }
}