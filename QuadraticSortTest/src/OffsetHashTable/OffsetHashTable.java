package OffsetHashTable;

import Arrays.DynamicArray;

public class OffsetHashTable {
    int TABLE_SIZE = 3;
    DynamicArray<OffsetHashTableObject> table;

    public OffsetHashTable(int size) {
        TABLE_SIZE = size;
        table = new DynamicArray<OffsetHashTableObject>(TABLE_SIZE);
    }

    public int get_size() {
        int size = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.println(i + " " + TABLE_SIZE + " " + table.getSize());
            if (table.getValue(i) != null) {
                size++;
            }
        }
        return size;
    }

    public void add(String data) {
        int key = data.hashCode() % TABLE_SIZE; // key is the index
        OffsetHashTableObject newObject = new OffsetHashTableObject(key, data);

        while (table.getValue(key) != null) {
            key++;

            if (key >= table.getSize()) {
                return;
            }
        }
        table.insertValue(key, newObject);
    }

    public OffsetHashTableObject get(String data) {
        int key = data.hashCode() % TABLE_SIZE;
        if (table.getValue(key).value.equals(data)) {
            return table.getValue(key);
        } else {
            for (int i = 0; i < table.getSize(); i++) {

                if (table.getValue(i) != null && table.getValue(i).value.equals(data)) {
                    return table.getValue(i);
                }
            }
            return null;
        }
    }

    public void remove(String data) {
        int index = data.hashCode() % TABLE_SIZE;
        if (table.getValue(index).value.equals(data)) {
            table.removeValue(index);
        } else {
            for (int i = index; i < table.getSize(); i++) {
                if (table.getValue(i) != null && table.getValue(i).value.equals(data)) {
                    table.removeValue(i);
                    return;
                }
            }
        }
    }
}