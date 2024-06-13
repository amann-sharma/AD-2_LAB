import java.util.*;

public class ChainingHashing {
    static class MyHashMap {
        private static final int SIZE = 10;
        List<Integer>[] hashTable;

        MyHashMap() {
            hashTable = new LinkedList[SIZE];
            for (int i = 0; i < SIZE; i++) {
                hashTable[i] = new LinkedList<>();
            }
        }

        private int hashFunction(int key) {
            return key % SIZE;
        }

        void insert(int key) {
            int index = hashFunction(key);
            hashTable[index].add(key);
        }

        boolean search(int key) {
            int index = hashFunction(key);
            return hashTable[index].contains(key);
        }

        void delete(int key) {
            int index = hashFunction(key);
            hashTable[index].remove((Integer) key);
        }

        void display() {
            for (int i = 0; i < SIZE; i++) {
                System.out.print(i + ": ");
                for (int num : hashTable[i]) {
                    System.out.print(num + " -> ");
                }
                System.out.println("null");
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.insert(10);
        map.insert(20);
        map.insert(15);
        map.insert(25);
        map.insert(35);

        map.display();

        int key = 15;
        System.out.println("Key " + key + " found: " + map.search(key));
        map.delete(key);

        System.out.println("After deleting key " + key + ":");
        map.display();
    }
}
