import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanCoding {
    // Function to build Huffman Tree
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        // Create a leaf node for each character and add it to the priority queue
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            priorityQueue.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Merge the two smallest nodes until only one node remains in the queue (the root)
        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode parent = new HuffmanNode('\0', left.frequency + right.frequency);
            parent.left = left;
            parent.right = right;

            priorityQueue.offer(parent);
        }

        // The remaining node is the root of the Huffman Tree
        return priorityQueue.poll();
    }

    // Function to generate Huffman codes
    public static Map<Character, String> generateHuffmanCodes(HuffmanNode root) {
        Map<Character, String> codes = new HashMap<>();
        generateCodesRecursive(root, "", codes);
        return codes;
    }

    private static void generateCodesRecursive(HuffmanNode node, String code, Map<Character, String> codes) {
        if (node == null) return;
        if (node.data != '\0') {
            codes.put(node.data, code);
        }
        generateCodesRecursive(node.left, code + "0", codes);
        generateCodesRecursive(node.right, code + "1", codes);
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        Map<Character, Integer> frequencies = new HashMap<>();

        // Count character frequencies
        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        // Build Huffman Tree
        HuffmanNode root = buildHuffmanTree(frequencies);

        // Generate Huffman Codes
        Map<Character, String> codes = generateHuffmanCodes(root);

        // Display Huffman Codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
