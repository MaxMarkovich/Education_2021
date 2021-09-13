package HashTable;

public class Hash {
    int INITIAL_SIZE = 5;
    private HashObject[] HashTableObjects = new HashObject[INITIAL_SIZE];

    private int toHash(String key) {
        return key.hashCode() % INITIAL_SIZE;
    }

    public void add(String key, String value) {
        int hash = toHash(key);
        HashObject HashObject = new HashObject(key, value);

        if (HashTableObjects[hash] == null) {
            HashTableObjects[hash] = HashObject;
        } else {
            HashObject temp = HashTableObjects[hash];

            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = HashObject;
        }
    }

    public String get(String key) {
        int hash = toHash(key);

        if (HashTableObjects[hash] != null) {
            HashObject temp = HashTableObjects[hash];

            while (!temp.key.equals(key) && temp.next != null ) {
                temp = temp.next;
            }
            return temp.value;
        }
        return null;
    }

    public void remove(String key) {
        int hash = toHash(key);

        if (HashTableObjects[hash].key.equals(key)) {
            HashTableObjects[hash].next = null;
            HashTableObjects[hash] = null;
        } else {
            HashObject temp = HashTableObjects[hash];

            while (temp.next != null) {
                assert temp.key != null;
                if (temp.key.equals(key)) {
                    temp.key = null;
                }
            }
        }
    }
}