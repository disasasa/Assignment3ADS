import org.w3c.dom.Node;

import java.util.*;

class MyHashTable<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private static final double LOAD_FACTOR = 0.75;

    private int size;
    private LinkedList<Node<K, V>>[] buckets;

    public MyHashTable() {
        buckets = new LinkedList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }
}