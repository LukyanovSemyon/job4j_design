package ru.job4j.map;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Iterable<K> {
    private static int count;
    private HashTable<K, V>[] hashTable;
    private final double loadFactor;
    private int size;

    public SimpleMap() {
        this.size = 4;
        this.loadFactor = 0.5;
        this.hashTable = new HashTable[size];
    }

    @Override
    public String toString() {
        return "SimpleMap{" + "hashTable=" + Arrays.toString(hashTable) + '}';
    }

    public static class HashTable<K, V> {
        K key;
        V value;

        public HashTable(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "HashTable{" + "key="
                    + key + ", value="
                    + value + '}';
        }

        public K getKey() {
            return key;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            HashTable<?, ?> hashTable = (HashTable<?, ?>) o;
            return Objects.equals(key, hashTable.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public V getValue() {
            return value;
        }
    }

    boolean insert(K key, V value) {
        int hashKey = key.hashCode() % size;
        double lf = (double) count / (double) size;
        if (lf >= loadFactor) {
            size = size * 2;
            HashTable<K, V>[] g = hashTable;
            hashTable = new HashTable[size];
            for (HashTable<K, V> i : g) {
                if (i != null) {
                    int hashKeyNew = i.getKey().hashCode() % size;
                    hashTable[hashKeyNew] = i;
                }
            }
        }
        if (hashTable[hashKey] != null) {
            return false;
        }
//        while (hashTable[hashKey] != null) {
//            hashKey++;
//            hashKey %= size;
//        }
        hashTable[hashKey] = new HashTable<>(key, value);
        count++;
        return true;
    }

    V get(K key) {
        int hashKey = key.hashCode() % size;
        if (hashTable[hashKey] == null) {
            return null;
        } else {
            return (V) hashTable[hashKey].getValue();
        }
    }

    boolean delete(K key) {
        int hashKey = key.hashCode() % size;
        hashTable[hashKey] = null;
        count--;
        return true;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            int index;
            final HashTable<K, V>[] it = hashTable;


            @Override
            public boolean hasNext() {
                while (index < size - 1 & it[index] == null) {
                    index++;
                }
                return it[index] != null & index < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return it[index++].getKey();
            }
        };
    }

    public static void main(String[] args) {
        SimpleMap<String, Integer> v = new SimpleMap<>();
        v.insert("h", 1);
        v.insert("d", 2);
        v.insert("a", 2);
        System.out.println(v);
        v.insert("g", 3);
        System.out.println(v);
        v.insert("v", 2);
        System.out.println(v);
        v.insert("b", 3);
        System.out.println(v);
        v.delete("a");
        System.out.println(v);
        System.out.println(v.get("b"));
        Iterator<String> it = v.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
