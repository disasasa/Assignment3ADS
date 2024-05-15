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

    public void put(K key, V value) {
        if (key == null)
            throw new IllegalArgumentException("Key cannot be null");

        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        bucket.add(new Node<>(key, value));
        size++;
        if ((double) size / buckets.length > LOAD_FACTOR)
            resize();
    }

    public V get(K key) {
        int index = getIndex(key);
        LinkedList<Node<K, V>> bucket = buckets[index];
        for (Node<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    private void resize() {
        LinkedList<Node<K, V>>[] oldBuckets = buckets;
        buckets = new LinkedList[oldBuckets.length * 2];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (LinkedList<Node<K, V>> bucket : oldBuckets) {
            for (Node<K, V> node : bucket) {
                int index = getIndex(node.key);
                buckets[index].add(node);
            }
        }
    }

    public void printBucketSizes(int numBuckets) {
        for (int i = 0; i < Math.min(numBuckets, buckets.length); i++) {
            System.out.println("Bucket " + i + ": " + buckets[i].size() + " elements");
        }
    }

    private static class Node<K, V> {
        private final K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}