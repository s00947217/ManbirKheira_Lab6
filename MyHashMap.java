import java.util.LinkedList;

// Lab 6 - HashMap Implementation
// Your Name: Manbir S Kheira

public class MyHashMap<K, V> implements MyMap<K, V> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    private LinkedList<Entry<K, V>>[] table = new LinkedList[DEFAULT_INITIAL_CAPACITY];
    private int size = 0;

    public MyHashMap() {}

    @Override
    public void clear() {
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
    }

    @Override
    public boolean containsKey(K key) {
        int bucketIndex = hash(key.hashCode());
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (LinkedList<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    if (entry.value.equals(value)) return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket != null) {
            for (Entry<K, V> entry : bucket) {
                if (entry.key.equals(key)) return entry.value;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null) {
            table[bucketIndex] = new LinkedList<>();
        }

        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                return oldValue;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
        return null;
    }

    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if (bucket != null) {
            bucket.removeIf(entry -> entry.key.equals(key));
            size--;
        }
    }

    @Override
    public int size() {
        return size;
    }

    private int hash(int hashCode) {
        return Math.abs(hashCode) % table.length;
    }

    // Getter for table
    public LinkedList<Entry<K, V>>[] getTable() {
        return table;
    }

    // Updated Entry class
    public static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
