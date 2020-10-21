package hu.unideb;

import java.beans.PropertyEditorSupport;
import java.util.*;

public class SajatLinkedMap<K, V> implements Map<K, V> {
    private int size;
    private Node<K, V> rootNode;

    public SajatLinkedMap() {
        size = 0;
        rootNode = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            if (currentNode.getValue().equals(value)) {
                return true;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    @Override
    public V get(Object key) {
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                return currentNode.getValue();
            }
            currentNode = currentNode.next;
        }

        return null;
    }

    @Override
    public V put(K key, V value) {
        // should put the new kv pair in front of the current root
        V possiblyStored = get(key);
        if (possiblyStored != null) {
            return possiblyStored;
        }
        else {
            Node<K, V> newNode = new Node<>(key, value, rootNode);
            rootNode = newNode;
            size++;
            return rootNode.getValue();
        }
    }

    @Override
    public V remove(Object key) {
        Node<K, V>  currentNode = rootNode;

        if (currentNode != null) {
            if (currentNode.getKey().equals(key)) {
                V res = currentNode.getValue();
                rootNode = rootNode.getNext();
                size--;
                return res;
            }

            while (currentNode.getNext() != null) {
                if (currentNode.getNext().getKey().equals(key)) {
                    V res = currentNode.getNext().getValue();
                    currentNode.setNext(currentNode.getNext().getNext());
                    size--;
                    return res;
                }
                currentNode = currentNode.getNext();
            }
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach((key, value) -> put(key, value));
    }

    @Override
    public void clear() {
        size = 0;
        rootNode = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> retSet = new HashSet<>();
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            retSet.add(currentNode.getKey());
            currentNode = currentNode.next;
        }

        return retSet;
    }

    @Override
    public Collection<V> values() {
        Collection<V> resCollection = new LinkedList<>();
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            resCollection.add(currentNode.getValue());
            currentNode = currentNode.next;
        }

        return resCollection;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> retSet = new HashSet<>();
        Node<K, V>  currentNode = rootNode;

        while (currentNode != null) {
            retSet.add(new AbstractMap.SimpleEntry<>(currentNode.getKey(), currentNode.getValue()));
            currentNode = currentNode.next;
        }

        return retSet;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
