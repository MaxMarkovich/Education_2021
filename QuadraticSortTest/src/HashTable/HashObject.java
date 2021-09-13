package HashTable;

public class HashObject {
    String key;
    String value;
    HashObject next;

    public HashObject(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}