public class QuadraticProbingHashing {
    static class MyHashMap {
        private static final int SIZE = 10;
        int[] hashTable;
        boolean[] isOccupied;

        MyHashMap() {
            hashTable = new int[SIZE];
            isOccupied = new boolean[SIZE];
        }

        private int hashFunction(int key) {
            return key % SIZE;
        }

        void insert(int key) {
            int index = hashFunction(key);
            int i = 0;
            while (isOccupied[index]) {
                index = (index + i * i) % SIZE;
                i++;
            }
            hashTable[index] = key;
            isOccupied[index] = true;
        }

        boolean search(int key) {
            int index = hashFunction(key);
            int i = 0;
            while (isOccupied[index]) {
                if (hashTable[index] == key)
                    return true;
                index = (index + i * i) % SIZE;
                i++;
            }
            return false;
        }

        void delete(int key) {
            int index = hashFunction(key);
            int i = 0;
            while (isOccupied[index]) {
                if (hashTable[index] == key) {
                    isOccupied[index] = false;
                    return;
                }
                index = (index + i * i) % SIZE;
                i++;
            }
        }

        void display() {
            for (int i = 0; i < SIZE; i++) {
                if (isOccupied[i])
                    System.out.println(i + ": " + hashTable[i]);
                else
                    System.out.println(i + ": null");
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
