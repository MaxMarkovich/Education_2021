package BinarySearchTree;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BinarySearchTreeTests {

    // GET DATA METHODS //
    @Test
    public void getSuccessor_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijk";
        String actual = tree.getSuccessor(tree.search("abcdefghij")).data;
        assertEquals(expected, actual);
    }

    @Test
    public void getSuccessor_WrongTypePassedIn_returnsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");


        Object actual = tree.getSuccessor(tree.search("ergergergerg"));
        assertNull(actual);
    }

    @Test
    public void getSuccessor_NotFound_returnsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");


        Object actual = tree.getSuccessor(tree.search("abcdefghijkl"));
        assertNull(actual);
    }

    @Test
    public void getPredecessor_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghi";
        String actual = tree.getPredecessor(tree.search("abcdefghij")).data;
        assertEquals(expected, actual);
    }

    @Test
    public void getPredecessor_WrongTypePassedIn_returnsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.getPredecessor(null);
        assertNull(actual);
    }

    @Test
    public void getPredecessor_NotFound_returnsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.getPredecessor(tree.search("f"));
        assertNull(actual);
    }

    @Test
    public void getMin_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcd";
        String actual = tree.getMin().data;
        assertEquals(expected, actual);
    }

    @Test
    public void getMax_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijkl";
        String actual = tree.getMax().data;
        assertEquals(expected, actual);
    }

    @Test
    public void search_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijkl";
        String actual = tree.search("abcdefghijkl").data;
        assertEquals(expected, actual);
    }

    @Test
    public void search_NotFound_returnsNull() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        Object actual = tree.search("f");
        assertNull(actual);
    }

    // ACTION TESTS //
    @Test
    public void delete_ONECHILD_isRIGHTchild_hasRIGHTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefg");
        tree.insert("abcdefghi");
        tree.insert("abcdefgh");
        tree.insert("abcdefghig");

        tree.delete(tree.search("abcdefghi"));

        String expected = "abcdefghig";
        String actual = tree.search("abcdefgh").right.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isRIGHTchild_hasLEFTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefg");
        tree.insert("abcdefghig");
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");

        tree.delete(tree.search("abcdefghig"));

        String expected = "abcdefghi";
        String actual = tree.search("abcdefgh").right.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isLEFTchild_hasLEFTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefg");
        tree.insert("abcdefgh");
        tree.insert("abcdef");
        tree.insert("abcde");

        tree.delete(tree.search("abcdef"));

        String expected = "abcde";
        String actual = tree.search("abcdefg").left.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ONECHILD_isLEFTchild_hasRIGHTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcdefg");

        tree.delete(tree.search("abcde"));

        String expected = "abcdefg";
        String actual = tree.search("abcdefgh").left.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_ZEROCHILDREN_isRIGHTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcdefg");

        tree.delete(tree.search("abcdefg"));

        Object actual = tree.search("abcdefg");
        assertNull(actual);
    }

    @Test
    public void delete_ZEROCHILDREN_isLEFTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");

        tree.delete(tree.search("abcd"));


        Object actual = tree.search("abcd");
        assertNull(actual);
    }

    @Test
    public void delete_TWOCHILDREN_isLEFTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcde");
        tree.insert("abcdefghijkl");
        tree.insert("abcdef");
        tree.insert("abcdefghijklmn");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("ab");
        tree.insert("abcdefghi");
        tree.insert("abc");
        tree.insert("abcdefgh");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghijklmo");
        tree.insert("abcdefg");
        tree.insert("abcdefghijklmnop");
        tree.insert("abcdefg");

        tree.delete(tree.search("abcde"));

        String expected = "abcdef";
        String actual = tree.search("abcdefgh").left.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_TWOCHILDREN_isRIGHTchild_positive() {
        BinarySearchTree tree = new BinarySearchTree();


        tree.insert("abcdefgh");
        tree.insert("abcde");
        tree.insert("abcdefghijkl");
        tree.insert("abcdef");
        tree.insert("abcdefghijklmn");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("ab");
        tree.insert("abcdefghi");
        tree.insert("abc");
        tree.insert("abcdefgh");
        tree.insert("abcdefghijklmnopq");
        tree.insert("abcdefghijk");
        tree.insert("abcdefghijklmo");
        tree.insert("abcdefg");

        tree.delete(tree.search("abcdefghijkl"));

        String expected = "abcdefghijklmn";
        String actual = tree.search("abcdefgh").right.data;
        assertEquals(expected, actual);
    }

    @Test
    public void delete_WrongType_DoNothing() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");

        tree.delete(null);
    }

    @Test
    public void delete_root_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcd");
        tree.insert("ab");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcdefgh");
        tree.insert("abc");
        tree.insert("a");
        tree.insert("abcdef");

        tree.delete(tree.root);

        String expected = "abcde";
        String actual = tree.root.data;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_positive() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("abcdefgh");
        tree.insert("abcdefghi");
        tree.insert("abcde");
        tree.insert("abcd");
        tree.insert("abcdefghij");
        tree.insert("abcdefghijkl");
        tree.insert("abcdefghijk");

        String expected = "abcdefghijkl";
        String actual = tree.search("abcdefghijkl").data;
        assertEquals(expected, actual);
    }

    @Test
    public void insert_WrongType_doNothing() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(null);
    }
}