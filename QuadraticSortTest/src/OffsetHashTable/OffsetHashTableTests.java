package OffsetHashTable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OffsetHashTableTests {

    @Test
    public void initialization() {
        OffsetHashTable table = new OffsetHashTable(5);
    }

    @Test
    public void add_SizeTest() {
        OffsetHashTable table = new OffsetHashTable(5);
        table.add("hello");

        int expected = 1;
        int actual = table.get_size();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void add_ValueTest() {
        OffsetHashTable table = new OffsetHashTable(5);
        table.add("hello");

        String expected = "hello";
        String actual = table.get("hello").value;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void get_ValueTest() {
        OffsetHashTable table = new OffsetHashTable(5);
        table.add("hello");

        String expected = "hello";
        String actual = table.get("hello").value;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void get_SizeTest() {
        OffsetHashTable table = new OffsetHashTable(5);
        table.add("hello");

        int expected = 1;
        int actual = table.get_size();
        Assertions.assertEquals(expected, actual);
    }
}