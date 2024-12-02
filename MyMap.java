// Lab 6 - HashMap Implementation
// Your Name: Manbir S Kheira

public interface MyMap<K, V> {
    void clear();

    boolean containsKey(K key);

    boolean containsValue(V value);

    V get(K key);

    boolean isEmpty();

    V put(K key, V value);

    void remove(K key);

    int size();
}
