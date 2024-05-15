import java.util.*;
class BST<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size;

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node<K, V> put(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public Iterable<Node<K, V>> iterator() {
        List<Node<K, V>> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(Node<K, V> node, List<Node<K, V>> list) {
        if (node == null) return;
        inOrderTraversal(node.left, list);
        list.add(node);
        inOrderTraversal(node.right, list);
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}