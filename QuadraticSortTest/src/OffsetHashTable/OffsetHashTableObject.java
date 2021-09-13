package OffsetHashTable;

public class OffsetHashTableObject {
    int key;
    String value;
    OffsetHashTableObject next;

    public OffsetHashTableObject(int key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public String get_data() {
        return value;
    }

    public OffsetHashTableObject get_next() {
        return next;
    }
}